# [JPA] Update Issue



JPA 에는 기본적으로 `findById()`, `save()` 등 select, insert 와 같은 쿼리를 손쉽게 사용할 수 있게 기능을 제공하는데 update와 관련된 동작을 할 때 생기는 Issue와 Solution과 관련한 문서 입니다.



### Insert, Update시 필드 세팅 관련 null Issue

insert, update를 진행할 때 모든 필드를 세팅하지 않으면 세팅되지 않은 필드들이 null로 sql문이 작성되는 문제가 있다.

```java
@Getter @Setter // Store Entity
@Entity @NoArgsConstructor
public class Store {
    
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String address;
    
    @Builder
    public Store(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
```

```java
@Service
@RequiredArgsConstructor  // 의존성 주입
public service {

    private final StoreRepository storeRepository;

    public Store update(final Long id) {
        Store store = Store.builder()
            .id(id)
            .name("Smart Store")
            .build();
            
        return storeRepository.save(store);    
    }
}
```

update 호출시 Entity에 @DynamicUpdate 어노테이션을 붙였으니 name만 업데이트 되어야 한다.

```mysql
UPDATE Store
SET name='Smart Store', address = null
WHERE id = 1
```

**하지만 예상한 결과와 다르다.**

#### Why?

**영속성** 으로 인해 발생하는 문제. insert 같은 경우는 DB의 데이터와 관계없이 새로운 데이터를 만들어서 넣는 작업이므로 @DynamicInsert 에서 영속성이 없어도 null 필드는 제외하고 insert 쿼리를 실행한다.

반면에 UPDATE는 db안에 저장된 데이터를 변경하는 것이기 때문에 영속성 이라는 개념이 필요하다. 위의 update 함수에서 행위는 비영속성 행위로 db 와 연결중이 아니기 때문에 update 함수를 호출해도 당연히 변경을 감지할 수 없는것 이다.



>  update는 insert 와 다르게 null이 무조건 제외되는 것이 아니다.
>
> 실제 데이터가 1 이었다가 null로 변경되면 null도 변경된 필드이기 때문에 순수하게 null 로 세팅되엇다고 제외되면 안된다. 그래서 실제 db의 row 데이터와 비교해야한다.



영속성을 유지하려면 DB 에서 데이터를 조회해오면 영속성이 유지된다. (1차 캐시)

```java
Store store = storeRepository.findById(id); // 조회된 Entity 는 영속성 유지중
```

<br>

**update 함수를 수정해보자**

```java
@Service
@RequiredArgsConstructor
public Service {
    
    private final StoreRepository storeRepository;
    
    public Store save(final Long id) {
        
        Store store = storeRepository.findById(id); // 1번 조회
        
        store.changeName("Smart Store");
        return storeRepository.save(store); // 1번 조회 1번 update
        
    }
}
```

**위의 결과는 조회를 2번 한다.** 

#### Why

이유는 JPA는 insert, update의 구분이 없다. Entity 에 @id 어노테이션이 붙어있는 필드의 값을 세팅하고 save 를 하면 insert, update 여부를 판단하기 위해 findById 로 조회를 해온다. 값이 있으면 update 없으면 insert 를 실행한다. 그래서 조회가 2번 일어나고 있는것!



그럼 어떻게 해야할까? 이대로 진행하면 update를 할 때마다 조회를 해야하는데 그럼 자원낭비가 심하다.

**JPA 영속성 개념을 이용하여 update**

영속성이 유지되는 Entity 는 Transaction 이 종료되면 변경된 필드를 자동으로 감지하여 db에 commit 해준다. 이와 같은 개념이 **Dirty Cehcking** 이다.



영속성 개념을 적용하도록 소스를 수정해보자.

```java
@Service
@RequiredArgsConstructor
public StoreService {
    private final StoreRepository storeRepository;
    
    @Transactional
    public Store save(final Long id) {
        Store store = storeRepository.findById(id); //  1번 조회
        
        store.changeName("Smart Store");
        return store; // transaction 이 종료되는 시점에 변경 필드를 업데이트한다.
    }
}
```

이렇게 구성하면 update시에 select 를 해오지 않아도 된다.

만약에 @Setter 가 Entity 에 붙어있었 다면 개발자들이 무분별하게 set 을 사용하는 환경을 만들어주는 것이다. 그럼 Transaction 이 종료되면 Entity 에 set 을 한 모든 필드를 감지하여 update 를 하게 된다. 그렇게 되면 데이터가 왜 바뀌었는지 찾는데 한참걸리게 된다!!



#### 결론

* 영속성을 파악하고 상황에 맞게 사용하자. 의미없는 자원을 줄이자.
* @Setter 와 생성자를 제외하고 의미있는 메서드, Builder 를 사용하여 일관성을 보존하면서 Entity 를 사용하는것이 좋다!





**References :**

* [[JPA] 프로젝트에 JPA를 적용하며.... ( save편 )](https://jessyt.tistory.com/35)