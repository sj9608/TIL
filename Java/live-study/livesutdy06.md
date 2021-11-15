# live study Week06 상속

# 목표

자바의 상속에 대해 학습하세요.

# 학습할 것 (필수)

- 자바 상속의 특징
- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
- 추상 클래스
- final 키워드
- Object 클래스



## 상속

* 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것
* 코드의 재사용성을 높이고 중복을 제거하여 생산성과 유지보수에 좋음

상속을 구현하는 방법은 다음과 같다.

```java
class Child extends Parent {
  ...
}
```

새로 작성하는 클래스 이름뒤에 `extends` 와 함께 상속받고자 하는 클래스의 이름을 적어주면 된다.

**상속을 사용하는경우**

* 상위 클래스와 필요한 하위 클래스의 관계에 대해 잘 알고있는 경우
* 프로젝트 구조 자체가 상속을 위해 설계된 경우
* **is - a** 관계가 명확한 경우 (Male is Person, Female is Person)

## 상속의 특징

* 자식 클래스는 부모 클래스의 모든 멤버를 상속받는다.
* **생성자와 초기화 블럭은 상속되지 않는다. 멤버만 상속된다.**
* **자손 클래스의 멤버 개수는 부모 클래스보다 항상 같거나 많다.**
* 모든 클래스는 암묵적으로 **Object 클래스를 상속받는다.** 



### 단일 상속 (Single Inheritance)

* **자바에서는 오직 단일 상속만 허용** (C++ 은 다중상속 허용)
* 단일 상속은 클래스 간의 관계가 명확해지고 코드의 신뢰성을 높여준다.
* 다중 상속이 필요한 경우 **다중 레벨 상속의 구조로 해결할 수 있다.**



#### 다중 레벨 상속 구조

```java
class high {
  
}

class middle extends high {
  
}

class low extends middle {
  
}
```



## Super 키워드

* 상위 클래스로부터 상속받은 필드나 메서드를 하위 클래스에서 참조하는데 사용하는 참조 변수이다.
* 클래스의 멤버 변수와 지역변수의 이름이 같을 때 `this` 를 붙여서 구별 하는것과 비슷
* 상위 클래스의 멤버와 하위 클래스의 멤버를 구분할 때 `super` 를 사용하여 다음과 같이 구별할 수 있다.

```java
public class A {
  protected String property = "properties";
  
  public void printProperties() { 
    System.out.println("A.printProperties");
    System.out.println(property); 
  } 
} 

public class B extends A { 
  protected String property = "properties of Sub Class";
  
  @Override 
  public void printProperties() { 
    super.printProperties();  // properties
    System.out.println("B.printProperties"); 
    System.out.println(super.property); // A.printProperties
    System.out.println(property); // properties of Sub Class
  }
}
```



## Super() 메서드

* 상위 클래스의 생성자를 호출하는데 사용한다.
* 하위 클래스의 인스턴스를 생성하면, 하위클래스의 멤버와 상위클래스의 멤버가 모두 합쳐진 하나의 인스턴스가 생성된다.
* 이 때 상위 클래스의 멤버의 초기화 작업이 수행되어야 하기 때문에 하위 클래스의 생성자에서 상위 클래스의 생성자가 호출되어야 한다.
* 상위 클래스의 멤버가 초기화 되어있어야 하위 클래스에서 사용할 수 있기 때문
* **기본적으로 하위 클래스의 생성자에서 super() 메서드는 자동으로 생성해준다.**



## 메소드 오버라이딩 (Method Overriding)

상위 클래스로부터 상속받은 메서드의 내용을 변경(재정의) 하는것을 오버라이딩 이라고 한다.

> override의 사전적 의미는 overwrite (덮어쓰다) 이다.

* **조건** : 상위 클래스에서 선언된 메서드명, 매개변수 와 반환값이 동일해야한다.
  * 리턴값을 다르게 설정하면 `attempting to use incompatible return type` 에러 발생







## 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)

* 오버라이딩된 메서드들이 있을 경우 어떤 메서드를 호출할지 런타임에서 결정하는 것.
* 해당 메서드 참조에 의해 호출될 때 객체 유형에 따라 실행할 메서드를 결정하게 된다.



## 추상 클래스

* 클래스가 설계도 라면 추상 클래스는 미완성 설계도
* 하나의 추상 메서드를 지니는 클래스.
* 유사한 여러 클래스의 동일한 부분을 잘라내어 추상화 하고 공통화한 클래스
* 추상 클래스는 주로 클래스의 기반 뼈대나 공통 처리(재사용)에 사용한다.



### 추상 클래스 구현

```java
abstract class Player {
  ...;
  abstract void play();
}
```

* 이렇게 구현한 추상 클래스는 다른 클래스에 상속시킨뒤 메서드 오버라이딩을 통해 정의하고 사용해야 한다.

* **장점**은 유사한 코드를 반복작성하지 않고 상속받아서 확장할 수 있다.
* **단점**은 상속 계층이 깊어질 수록 상위 계층부터 동작을 이해해야 한다.(**유지보수가 어려워짐**)



## final 키워드

**제어자(modifier)** 중 하나로 해당 제어자가 작성된 **변수, 메서드, 클래스 등에 대해 상속, 변경을 금지한다는 의미**

> 대표적인 final 클래스는 **String, Math** 등이 있다.

```java
private final String name = "llee";
name = "kim" // 금지 (컴파일 에러)
```





## Object 클래스

모든 클래스의 **최상위 클래스** , 모든 클래스는 Object 클래스를 상속받음

* equals(), toString(), clone() 등 유틸 메서드
* 이에 관해선 java.lang 패키지와 유용한 클래스에서 더 자세히 학습.

