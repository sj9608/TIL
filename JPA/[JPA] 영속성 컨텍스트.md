# [JPA] 영속성 컨텍스트

## 영속성 컨텍스트 (Persistence Context)

* persistence object (영속 객체)를 관리하는 캐시!
* entity object 의 lifeCycle을 관리한다.



#### persistence object 등록 (em.persist())

```java
// 엔티티를 생성한 상태 (비영속) New/ Transient
Member member = new Member();
member.setId("member1");
member.setUsername("회원1");

// 엔티티를 영속 entity manager가 member객체를 영속성 컨텍스트 (1차캐시)에 올림
em.persist(member);
```

영속성 컨텍스트에 올린다는 말은 해당 Entity 를 복사해서 1차캐시에 올려놓음



<img width="640px;" src="https://ultrakain.gitbooks.io/jpa/content/chapter3/images/JPA_3_5.png">

* 1차 캐시의 키는 **식별자 값**
* 식별자 값은 데이터 베이스 기본키와 매핑
* 영속성 컨텍스트에 데이터를 저장하고 조회하느 모든 기준은 데이터 베이스 기본 키 값



### 엔티티 조회 (persistence object find)

```java
Member member = em.find(Member.class, "member1"); // id가 member1 인 Member를 조회
```



**여기서 포인트**

> em.find() 를 호출 하면 **1차 캐시에서 Entity를 조회**한다. 이 때 Entity가 **1차 캐시에 없을 경우 데이터 베이스를 조회**한다.



<img width="640px" src="https://ultrakain.gitbooks.io/jpa/content/chapter3/images/JPA_3_7.png">



#### Persistence Object 의 동일성 보장

```java
Member a = em.find(Member.class, "member1");
Member b = em.find(Member.class, "member1");

assertEquals(a, b); // Success
```

* 두 객체는 같은 인스턴스
* **Persist Context 는 성능상 이점과 Entity의 동일성을 보장한다.**



### Entity 등록

```java
EntityManager em = emf.createEntityManager();
EntityTransaction transaction = em.getTransaction();

// 엔티티 매니저는 데이터 변경 시 트랜잭션을 시작해야 한다.
transacation.begin(); // 트랜잭션 시작

em.persist(memberA);
em.persist(memberB);
// 여기까지는 INSERT Query를 수행하지 않음

// 커밋하는 순간 데이터 베이스에 INSERT Query를 수행한다.
trasaction.commit(); // 트랜잭션 커밋
```

* 엔티티 매니저는 트랜잭션을 커밋하기 전까지 데이터 베이스의 엔티티를 저장하지 않는다.
* 내부 쿼리 저장소에 INSERT QUERY를 모아둔 뒤
* 트랜잭션이 커밋될 때 모아둔 쿼리를 DB에 보낸다.
* **트랜잭션을 지원하는 쓰기 지연**



<img width="640px" src="https://ultrakain.gitbooks.io/jpa/content/chapter3/images/JPA_3_9.png" />

쓰기지연 SQL 저장소에 쿼리를 저장해둔다.



#### 트랜잭션 커밋, 플러시, 동기화

<img width="640px" src="https://ultrakain.gitbooks.io/jpa/content/chapter3/images/JPA_3_10.png"/>



### Entity 수정

* JPA는 **Entity를 수정할 때 단순히 Entity를 조회하고 데이터만 변경 하면 된다.**
* **update()** 라는 메서드는 없음
* **변경 감지 (Dirty Checking)** 기능을 사용해서 데이터 베이스에 자동 반영

<img width="640px" src="https://ultrakain.gitbooks.io/jpa/content/chapter3/images/JPA_3_11.png"/>

> flsuh() 시점에 스냅샷 (복사본) 과 Entity를 비교한다.

#### 수정 순서

1. 트랜잭션 커밋 -> Entity Manager 내부에서 먼저 플러시 호출
2. Entity 와 스냅샷을 비교해서 변경된 Entity 를 찾는다.
3. 변경된 Entity 가 있으면 수정 쿼리(Update)를 생성해서 **쓰기 지연 SQL 저장소**로 보낸다
4. 쓰기 지연 저장소의 SQL을 데이터 베이스로 보낸다.
5. 데이터베이스 트랜잭션을 커밋

> **Dirty Checking** 은 Persistence Context 가 관리하는 **Persistence Obejct** 에만 적용된다.



#### 업데이트 기본 전략

> **JPA의 기본 업데이트 전략은 모든 필드를 업데이트 한다.**

* 모든 필드를 사용하면 수정 쿼리가 항상 같음.
* 동일한 쿼리를 보내면 데이터베이스는 이전에 파싱된 쿼리는 재사용.



#### 필드가 많거나 저장되는 내용이 큰 경우

> 하이버네이트 확장 기능 사용

`@DynamicUpdate` 어노테이션을 사용하면 수정된 데이터만 동적으로 UPDATE QUERY를 생성

```java
@Entity
@org.hibernate.annotation.DynamicUpdate
@Table(name = "member")
public class Member { ... }
```



### Entity 삭제

Entity를 삭제하기 위해선 먼저 삭제 대상 엔티티를 조회해야 한다.



```java
Member memberA = em.find(Member.class, "memeber1");
em.remove(memberA); // Entity 삭제
```

* 엔티티 삭제 역시 즉시 삭제가 아닌 쓰기지연 SQL 저장소에 등록후
* em.remove(memberA) 를 호출하는 순간 Persistence Context 에서 제거한다.



### 플러시

> 플러시 (flush() ) 는 영속성 컨텍스트의 변경 내용을 데이터 베이스에 반영한다



#### 플러시 실행

1. 변경 감지 동작. 모든 엔티티를 스냅샷과 비교
2. 수정된 엔티티는 수정 쿼리를 만들어 쓰기 지연 SQL 저장소 등록
3. 쓰기지연 SQL 저장소의 쿼리를 데이터 베이스에 전송
   * 등록, 수정, 삭제 쿼리



#### 영속성 컨텍스트를 플러시하는 방법

1. em.flush() 직접 호출
2. 트랜잭션 커밋시 플러시가 자동으로 호출
3. JPQL (Java Persistence Query Langugage) 쿼리 실행시 플러시가 자동 호출



#### 직접 호출

* 테스트나 다른 프레임워크와 JPA를 함께 사용할 때를 제외하고 거의 사용하지 않음.



#### 트랜잭션 커밋 시 플러시 자동 호출

* 트랜잭션 커밋하기 전에 꼭 플러시 호출해서 변경 내용을 데이터 베이스에 반영해야 함.
* **JPA는 트랜잭션 커밋할 때 플러시를 자동 호출.**



#### JPQL 쿼리 실행 시 플러시 자동 호출

```java
em.persist(memberA);
em.persist(memberB);
em.persist(memberC);

// 중간에 조회
query = em.createQuery("select m from Member m", Member.class);
List<Member> members = query.getResultList();
```



#### 플러시 모드 옵션에 대한 설정

[자바 ORM 표준 JPA 프로그래밍 > 플러시](https://ultrakain.gitbooks.io/jpa/content/chapter3/chapter3.5.html)