# [JPA] Dirty Checking



문서를 읽기전 가벼운 용어정리

**Persistence Context** : persistence object를 관리하는 캐시, entity object의 life cycle을 관리하고 범위를 정의한다.

**LifeCycle of an Entity Object** : 

* New or Transient : session, DB 등과의 어떤 행동도 하지 않은 순수한 일반 객체
* Managed, or Persistent : 객체가 DB의 임의의 속성과 관련된 경우 영속, 지속상태
* Detached : DB와 연관이 되어있다가 Session 객체와 분리된 상태



### What is Dirty Checking

JPA를 구현한 Hibernate에는 관리되는 모든 Entity properties 를 확인하는 기능이 있는데. Entity가 Hibernate를 통해 로드 될 때마다 모든 Entity 속성 값과 함께 전체 Entity 객체의 추가 복사본을 만든다 (여기서 Entity는 entity type의 persist object를 의미함 )

Hibernate 는 모든 Persistence Object를 감시하며 작업 단위가 끝나면 어떤 Object가 수정되었는지 확인하고 수정된 모든 객체들에 대해 Update Query를 호출한다. 변경된 Object 만 감시하고 업데이트하는 이 프로세스를 Hibernate의 automatic Dirty Checking (변경감지) 라고 한다.



#### How does this happens?

Hibernate는 Persistence Context 내에 DB에 로드된 모든 Persistence Object 의 스냅샷(사본) 을 가지고 Object의 변경이 일어나거나 Dirty 한 객체를 감지한다.

트랜잭션이 끝나면 Hibernate는 알맞은 table lock과 특정 레코드를 업데이트하고 잠금을 해제하여 트랜잭션을 완료한다.







**References:**

* [Life Cycle of an entity object & Drity Checking in Hibernate](https://www.codementor.io/@narendrasharma95ns/life-cycle-of-an-entity-object-dirty-checking-in-hibernate-lvh1dh5jz)
* 