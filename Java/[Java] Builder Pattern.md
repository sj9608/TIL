# [Java] Builder Pattern



Builder pattern 은 디자인 패턴 중 하나로 인스턴스를 생성할 때 생성자 만을 통해서 객체를 생성하는데 어려움이 있어서 고안된 패턴이다. 바로 예시를 보자.

아래와 같은 클래스가 있다고 가정해보자.

```java
public class Member {
    private int no;
    private String name;
    private String department;
   	private String password;
    private int age;
    private String emaill;
    
    public Member (String name, String deaprtment, String password, int age, String emaill) {
        this.name = name;
        this.department = department;
        this.password = password;
        this.age = age;
        this.emial = email;
    }
}
```

해당 객체를 생성하려면 다음과 같은 코드를 작성해야 할 것이다.

```java
Member member = new Member ("hong", "R&D", "abcd1234", 24, "newMail@email.com");
```

위와 같은 생성자를 마주쳤을 때 각 파라미터들이 무엇을 의미하는지는 해당 클래스를 들어가서 생성자를 보지 않는 이상 명확하지 않을 것이다.

또한 요구사항이 변해 Member 클래스에 새로운 프로퍼티가 생겨나거나 타입이 변하거나 등등 여러가지 반복적인 변경이 필요하게 될 수 있다.

이러한 문제점을 해결하기 위해 고안된 패턴이라고 생각하면 된다.



### Builder Pattern 의 장점

빌더 패턴을 이용했을 때의 장점들은 다음과 같다.

* 필요한 데이터만 설정할 수 있다.
  * 특정 파라미터에 대한 설정을 하지 않을 때 추가적인 생성자를 만들거나 더미 값을 넣어줄 필요가 없다.
* 유연성을 확보할 수 있다.
  * 추가적인 변경(프로퍼티)이 있을 때 유연하게 대처할 수 있다.
* 가독성을 높일 수 있다.
  * 생성자의 파라미터 순서에 신경쓰지 않아도 된다.
* 변경 가능성을 최소화 할 수 있다.
  * 무분별한 Setter로 인한 불필요한 변경 가능성을 열어두지 않을 수 있다.



### Builder 패턴을 적용한 Member Class

```Java
/** 
* 위의 MemberClass 내부
*/

public static class MemberBuilder {
    private int no;
    private String name;
    private String department;
   	private String password;
    private int age;
    private String emaill;
    
    public MemberBuilder no(int no) {
        this.no = no;
        return this;
    }
    
    public MemberBuilder name(String name) {
        this.name = name;
        return this;
    }
    
    public MemberBuilder department(String department) {
        this.department = department;
        return this;
    }
    
    public MemberBuilder password(String password) {
        this.password = password;
        return this;
    }
    
    public MemberBuilder no(int age) {
        this.age = age;
        return this;
    }
    
    public MemberBuilder emaill(int emaill) {
        this.emaill = emaill;
        return this;
    }
    
    public Member build() {
        return new Member(no, name, department, password, age, email)
    }
}
```

위와 같이 Builder를 이용해서 값을 set 하면 Builder를 반환해서 메서드 체이닝 형식으로 사용가능하게 된다. 이를 빌더 패턴을 적용한 클래스 라고 한다.



### Builder 사용

```java
public static void main(String args[]) {
    MemberBuilder memberBuilder = new MemberBuilder();
    Member member = memberBuilder
        .name("hong")
        .no(14)
        .email("email@email.com")
        .department("R&D")
        .password("12341234")
        .age(24)
        .build();
}
```

기존의 생성자와 다르게 순서에 관계없이 함수를 호출해서 인스턴스를 만들수 있다.

하지만 아쉬운점이 있다면 대상 클래스와 그것을 연결할 빌더 클래스 총 2개의 클래스를 생성해야 한다.  이러한 점을 보완하고 코드량을 줄여주는 플러그인 **Lombok** 이 존재한다.



### Lombok 을 사용한 Builder Class

Builder를 만들고자 하는 클래스 위에 @Builder 어노테이션만 명시해주면 된다.

```java
@Builder
public class Member {
    private int no;
    private String name;
    private String department;
   	private String password;
    private int age;
    private String emaill;
    
}
```



#### Lombok builder 사용

```java
Member member = Member.builder()
    .name("hong")
    .no(14)
    .email("email@email.com")
    .department("R&D")
    .password("12341234")
    .age(24)
    .build();
```

