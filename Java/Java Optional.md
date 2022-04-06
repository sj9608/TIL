# Java Optional

> java.util.Optional\<T> Class

* Optional\<T> 클래스는 Integer나 Double 클래스처럼 'T' 타입의 객체를 포장해 주는 Wrapper Class
* Optional 인스턴스는 모든 타입의 참조 변수를 저장할 수 있다.



#### 사용이유

메서드가 반환할 결과값이 없음 을 명백하게 표현할 필요가 있고, null 을 반환하면 에러를 유발할 가능성이 높은 상황에서 메서드의 반환 타입으로 **Optional** 을 사용하자 는 것이 Optional 인스턴스를 만든 이유이자 사용하는 이유이다.

Optional 타입의 변수 값은 **절대 null 이 아니어야 하며** 항상 Optional 인스턴스를 가리켜야 한다.



### 1. Use `orElse() | orElseGet() | orElseThrow`

> instead isPresent() then Get()

```java
// Bad Code
Optional<Member> member = ...;

if (member.isPresent()) {
    return member.get();
} else {
    return null;
}

// Good
Optional<Member> member = ...;
return member.orElse(null);
```

가독성 및 효율 적인 측면에서 아래의 코드가 낫다.



### 2. orElseGet(() -> new ...)

> instead of orElse(new ...)

* orElse(...) 에서 ... 는 Optional 에 값이 있든 없든 무조건 실행된다.
* 따라서 해당 부분이 새로운 객체를 생성하거나 새로운 연산을 수행하는 경우에는 orElseGet() 을 사용하자.

> Optional에 값이 없으면 orElse() 의 파라미터로 실행된 값이 반환되므로 의미가 있지만. Optioanl에 값이 있다면 orElse() 안의 파라미터로 실행된 값이 무시되고 버려진다. 따라서 orElse() 안에 새 객체 생성이나 새로운 연산을 유발하지 않고 **이미 생성되었거나 이미 계산된 값일 때만 사용해야한다.**



orElseGet() 의 경우 안의 파라미터가 Optional에 값이 없을 때만 실행되기 때문에 불필요한 오버헤드가 없다.

```java
// Bad Code
Optional<Member> member = ...;
return member.orElse(new Member());

// Good
Optional<Member> member = ...;
// return member.orElseGet(() -> new Member())
return member.orElseGet(Member::new); // lambda 축약식 new Member(); 와 같음

// Good
Member EMTPY_MEMBER = new Member();
...
Optional<Member> member = ...;
return member.orElse(EMTPY_MEMBER); // 이미 생성되어 있던 값, 객체 등은 orElse 사용해도 좋음
```



참고로 **자바의 Collections 객체**는 emptyList() 라는 메서드를 통해 이미 생성된 static 변수인 EMPTY_LIST 를 반환하므로 orElse(Collections.emptyList()) 를 사용해도 괜찮다.

하지만 이런식으로 사용하게 되면 orElse(new ...) 나 orElse(연산유발 메서드) 같은 안티 패턴마저 정상적인 사용법으로 인식될 가능성이 생긴다.

따라서 **orElseGet(Collections::emptyList) 를 사용하는 것이 더 좋다.**



### 단순한 값을 얻을 목적이라면 null 비교

> Optional 은 비싼 자원 이므로 단순히 값이나 null을 얻을 목적이라면 null 비교를 쓰자.

```java
// Bad Code
return Optional.ofNullable(status).orElse(READY);

// Good
return status != null ? status : READY;
```



### 컬렉션 객체는 비어있는 컬렉션을 반환

> 컬렉션을 사용하면 null 이 아니라 비어있는 컬렉션을 반환하는 것이 좋을 때가 많다. 따라서 컬렉션은 Optional 대신 비어있는 컬렉션을 반환하자.

```java
List<Member> members = team.getMembers();
return Optional.ofNullable(members);

List<Member> members = team.getMembers():
return members != null ? members : Collections.emptyList();
```



더 자세한 내용은 아래 레퍼런스를 참조하자.



References:

* [Java Optional 바르게 쓰기](https://homoefficio.github.io/2019/10/03/Java-Optional-%EB%B0%94%EB%A5%B4%EA%B2%8C-%EC%93%B0%EA%B8%B0/)