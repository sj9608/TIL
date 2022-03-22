# [JPA] Persistence Management

> 영속성 관리 (매핑한 Entity를 Entity Manager를 통해 사용을 관리)



* Entity와 Table 간의 매핑을 설계하는 부분
* 매핑한 Entity를 실제 사용하는 부분



## Entity Manger Factory, Entity Manager

> DB를 하나만 사용하는 Application은 일반적으로 하나의 Entity Manager Factory를 사용한다. (이하 EMF)



### Entity Manager Factory

```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
```

- 만드는 비용이 상당히 큼.
- 한 개만 만들어서 어플리케이션 전체에서 공유하도록 설계.
- 여러 스레드가 동시에 접근해도 안전, 서로 다른 스레드 간 공유 가능.



### Entity Manager

```java
EntityManager em = emf.createEntityManager(); // 엔티티 매니저 생성
```

* 여러 스레드가 동시에 접근하면 동시성 문제 발생
* **스레드간 절대 공유하면 안된다**.
* 데이터베이스 연결이 필요한 시점까지 커넥션을 얻지 않는다.

<img width="620px" src="https://ultrakain.gitbooks.io/jpa/content/chapter3/images/JPA_3_1.png" />

<span style="float: right">출처 : https://ultrakain.gitbooks.io/jpa/content/chapter3/images/JPA_3_1.png</span>





## What is Persistence Context ?

> 영속성(지속성) 컨텍스트

```java
em.persist(member);
```

- 단순하게 회원 엔티티 저장
- 정확하게는 엔티티 매니저를 사용해서 회원 엔티티를 **`영속성 컨텍스트`**에 저장
- 논리적인 개념에 가까움
- 엔티티 매니저를 생성할 때 하나 만들어진다.
- **엔티티 매니저를 통해 영속성 컨텍스트에 접근하고 관리**할 수 있다.



## Entity Life Cycle

#### 4가지 상태

| 비영속(new/transient) | 영속성 컨텍스트와 전혀 관계가 없는 상태    |
| --------------------- | ------------------------------------------ |
| 영속(managed)         | 영속성 컨텍스트에 저장된 상태              |
| 준영속(detached)      | 영속성 컨텍스트에 저장되었다가 분리된 상태 |
| 삭제(removed)         | 삭제된 상태                                |

#### 생명주기

<img width="620px" src="https://ultrakain.gitbooks.io/jpa/content/chapter3/images/JPA_3_2.png"/>

<span style="float:right">출처: https://ultrakain.gitbooks.io/jpa/content/chapter3/images/JPA_3_2.png</span>



#### 비영속 

* 단순히 Entity 객체를 생성한 상태
* 영속성 컨텍스트, 데이터베이스와 상관없음
* `em.persist()` 호출 전

```java
Member member = new Member();
member.setId(100L);
member.setUsername("User1");
```



#### 영속

* 엔티티 매니저를 통해 엔티티를 영속성 컨텍스트에 저장
* 영속성 컨텍스트가 관리하는 엔티티를 영속 상태라고 한다.
* 영속상태 : **영속성 컨텍스트에 의해 관리된다는 뜻.**
* **em.find()**나 **JPQL를 사용해서 조회한 엔티티**도 영속 상태.
* `em.persist(member)  객체를 저장한 상태(영속)`



#### 준영속

- 영속성 컨텍스트가 관리하던 영속 상태의 엔티티를 영속성 컨텍스트가 관리하지 않으면 **"준영속 상태"**.
- **em.detach()** 호출로 준영속 상태 명시적 호출.
- **em.close()**를 호출해서 영속성 컨텍스트를 닫음.
- **em.clear()**로 영속성 컨텍스트 초기화.

```java
// 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
em.detach(member);
```



#### 삭제

엔티티를 영속성 컨텍스트와 데이타베이스에서 삭제.

```java
// 객체를 삭제한 상태(삭제)
em.remove(member);
```