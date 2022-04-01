# JPA Annotation Summary



## Annotations

### @Entity

> @Entity 어노테이션은 DB의 테이블과 1:1 매칭되는 객체 단위이며 Entity 객체의 인스턴스 하나가 테이블에서 하나의 레코드 값을 의미하며 **테이블과 매핑할 클래스** 에 **필수**로 붙여줘야 한다. 또한 기본 생성자는 **필수**

* **속성**

| property | functioin                       | defaultValue           |
| -------- | ------------------------------- | ---------------------- |
| name     | jpa에서 사용할 Entity 이름 지정 | 클래스 이름(CamelCase) |

<br>

<br>

### @Table

> @Table은 엔티티와 매핑할 테이블을 지정한다. 엔티티 이름은 테이블 이름으로 사용

| property              | function                                                     | defaultValue     |
| --------------------- | ------------------------------------------------------------ | ---------------- |
| name                  | 매핑할 테이블 이름                                           | 엔티티 이름 사용 |
| catalog               | catalog 기능이 있는 DB에서 catalog 매핑                      |                  |
| schema                | schema 기능이 있는 DB에서 schema 매핑                        |                  |
| uniqueConstraint(DDL) | DDL 생성시 유니크 제약조건을 만든다. 이 기능은 스키마 자동생성 기능을 사용해서 DDL을 만들 때만 사용된다. |                  |

<br><br>

### @Id

> @Id 어노테이션은 **PK** 컬럼을 지정한다.

<br>



### @Column

> @Colum 어노테이션은 별 다른 옵션을 설정하지 않는다면 생략이 가능하다. 즉 Entity(VO) 내부변수는 기본적으로 @Column 어노테이션을 포함한다.
>
> **In SrpingBoot** : 스프링 부트에서 spring.jpa.hibernate.ddl-auto 설정이 create, 혹은 update 인 경우 존재하지 않는 경우 컬럼이 생성해준다.
>
> @Column 도 @Entity 어노테이션과 동일하게 **name** 속성을 명시하지 않으면 Entity 클래스에 정의한 컬럼 변수의 이름으로 생성이 된다. 그렇기 때문에 CamelCase로 작성된 컬럼 변수가 있다면 UnderScore형식으로 name을 명시적으로 작성한다.

```java
@Column
private Long no;

@Column(length = 100)
private String id;

@Column
private Integer age;

@Column(name = "register_date")
private LocalDateTime registerDate;
```

<br><br>

### @GeneratedValue

>PK를 Integer, 혹은 Long으로 설정한경우 DB에서 AutoIncrement 혹은 sequence를 이용해서 관리하는데 이에 맞게 자동적으로 PK 값을 설정해주는 역할
>
>AI방식을 사용하는 경우 생성전략(strategy) 을 를 GenrationType.IDENTITY 로 설정하며 sequence 를 사용하는 DB의 경우 @SequenceGenrator를 함께 쓰는 경우도 있음

| proerpty | function                  | defaultValue        |
| -------- | ------------------------- | ------------------- |
| strategy | 생성전략 설정             | GenerationType.AUTO |
| genrator | @SequenceGenrator 를 지정 |                     |



#### Example

```java
@Entity
@Table(name = "member")
public class Member {
    
    @Id
    @SequenceGenrator(name = "seq", sequenceName = "member_no_seq")
    @GeneratedValue(strategy = GenrationType.SEQUENCE, generator = "seq")
    private Long no;    
    
    @Column(length = 100)
    private String id;j

    @Column
    private Integer age;

    @Column(name = "register_date")
    private LocalDateTime registerDate;
    
    ...
}
```



## **@EmbeddedId**

**-** 앞서 데이터베이스의 테이블은 기본적으로 유일한 값을 가지는데 그것을 **PK** 라고 이야기 한다고 설명하였다. 일반적인 경우에는 **PK** 를 단일 **@Id** 로 구성하지만 경우에 따라선 **복합키**로서 테이블의 **PK** 를 정의 하기도 한다. **복합키**는 두개 이상의 **@Id** 로 구성이 되는데 이를 직접 Entity 에 정의하는 것이 아니라 별도의 **Value** 를 사용해 **복합키**를 정의한다.df



 

\- 먼저 **Value** 를 생성한 다음 **@Embeddable** 어노테이션을 이용해 이 **Value** 가 **Entity** 에 삽입이 가능함을 명시 하고 **Entity** 에서는 **@EmbeddedId** 어노테이션을 이용해 이 **Entity** 에 해당 **Value** 를 **PK** 로 사용한다고 지정한다.

```java
@Embeddable
public class CompanyOrganizationKey implements Serializable {
	@Column(name = "company_code")
    private String companyCode;
    
    @Column(name = "organization_code")
    private String organizationCode;
}

@Entity(name = "company_organization")
public class CompanyOrganization {
	@EmbeddedId
    protected CompanyOrganizationKey companyOrganizationKey;
}
```



**Refrences :**

* [JPA 기본 Annotation 정리](https://www.icatpark.com/entry/JPA-%EA%B8%B0%EB%B3%B8-Annotation-%EC%A0%95%EB%A6%AC)