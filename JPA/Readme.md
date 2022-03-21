# JPA

### Java Persistence API ?

자바 플랫폼 SE, EE 를 사용하는 응용 프로그램에서 관계형 데이터 베이스의 관리를 표현하는 자바 API 이다.

간단하게 말해 자바 **ORM** (Object Relational Mapping)  기술에 대한 **표준 명세**로 자바 **클래스**와 DB **테이블을 매핑** 하는 API 라고 생각하자.



#### 특징

* SQL문을 쓰지 않고 Mehotd를 통해 DB를 조작할 수 있기 때문에 쿼리를 생각하기 보다 객체 모델을 이용해 비즈니스 로직을 짜는데 집중할 수 있다.
* 또한 Java 코드만 보기 때문에 가독성이 좀 더 좋아질 수 있으며 객체지향적인 코드의 작성이 가능하다. 이로 인해 생산성 또한 증가할 수 있음.
* JPA는 인터페이스 이기 때문에 Hibernate, Open JPA, EclipseLink 등등 을 이용해 구현해야함.





#### JPA 동작위치

자바 어플리케이션과 jdbc api 사이에서 동작한다.  JPA내부에서 JDBC API를 사용하여 SQL을 호출하고 DB와 통신한다. (개발자는 JPA를 사용 내부적으론 JDBC API가 동작한다.)

<img width="640px" src="https://ultrakain.gitbooks.io/jpa/content/chapter1/images/JPA.png" />

이미지 출처 : https://ultrakain.gitbooks.io/jpa/content/chapter1/images/JPA.png



#### 저장 및 조회 동작

* 저장하는 코드 `jpa.persist(member)` 

<img width="640px" src="https://ultrakain.gitbooks.io/jpa/content/chapter1/images/JPA_save.png"/>

* 조회하는 코드 `jpa.find(memberId)`

<img width="620px" src="https://ultrakain.gitbooks.io/jpa/content/chapter1/images/JPA_search.png" />

<br/>



#### JPA 사용이유

* **생산성**

  * 데이터베이스 설계 중심의 **패러다임을 객체 설계 중심**으로 역전
  * INSERT SQL을 작성하고 JDBC API 사용하는 **지루하고 반복적인 일을 JPA가 대신** 처리해준다.
  * JPA를 자바 컬렉션에 **객체를 저장하듯** JPA에게 저장할 객체를 전달.
  * CREATE TABLE같은 **DDL문 자동 생성**

* **데이터 접근 추상화와 벤더 독립성**

  * 데이터베이스 기술에 종속되지 않도록 한다.
  * 데이터베이스를 변경하면 JPA에게 다른 데이터베이스를 사용한다고 알려주면 됨.

  

JPA는 반복적인 CRUD SQL을 처리해준다. JPA는 매핑된 관계를 이용해서 SQL을 생성하고 실행하는데, 개발자는 어떤 SQL이 실행될지 생각만하면 되고, 예측도 쉽게 할 수 있다. 

추가적으로 JPA는 네이티브 SQL이란 기능을 제공해주는데 관계 매핑이 어렵거나 성능에 대한 이슈가 우려되는 경우 SQL을 직접 작성하여 사용할 수 있다.

**반복적인 CRUD SQL을 작성하고 객체를 SQL에 매핑하는데 시간을 보내기에는 우리의 시간이 너무아깝다.** 이미 많은 자바 개발자들이 오랫동안 비슷한 고민을 해왔고 문제를 해결하려고 많은 노력을 기울여왔다. 그리고 그 노력의 결정체가 바로 JPA다. JPA는 표준 명세만 570페이지에 달하고, JPA를 구현한 하이버네이트는 이미 10년 이상 지속해서 개발되고 있으며, 핵심 모듈의 코드 수가 이미 십만 라인을 넘어섰다. **귀찮은 문제들은 이제 JPA에게 맡기고 더 좋은 객체 모델링과 더 많은 테스트를 작성하는데 우리의 시간을 보내자**. **개발자는 SQL Mapper가 아니다.**



<span style="float: right;">**-출처: 자바 ORM 표준 JPA 프로그래밍 / 저자: 김영한 -**</span>

#### 출처

* [wikipedia JPA](https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94_%ED%8D%BC%EC%8B%9C%EC%8A%A4%ED%84%B4%EC%8A%A4_API)
* [[Spring JPA] JPA란?](https://dbjh.tistory.com/77)
* [[자바 ORM 표준 JPA 프로그래밍] Gitbook](https://ultrakain.gitbooks.io/jpa/content/chapter1/chapter1.3.html)
* [JPA는 도대체 뭘까? by adam2.log](https://velog.io/@adam2/JPA%EB%8A%94-%EB%8F%84%EB%8D%B0%EC%B2%B4-%EB%AD%98%EA%B9%8C-orm-%EC%98%81%EC%86%8D%EC%84%B1-hibernate-spring-data-jpa)

