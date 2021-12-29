# Java Bean

**자바 빈은 특정 기준을 가진 자바객체의 `표준` 이다.**

> 그냥 단순히 코드 컨벤션 이다. 많은 라이브러리들이 이 표준에 의존한다.

기준은 다음과 같다.

1. 모든 속성(property) 은 private 해야하며 getter, setter를 이용
2. 인자가 없는 public constructor 를 포함
3. 직렬화 기능 을 구현해야함 **Implements Serializable**

<br/>

> Serializable ?
> java.io.Serializable interface를 통해 class를 Serializabillity 하게 구현한다.
>
> 쉽게 말해 직렬화 가능한 객체는 파일, 객체 데이터베이스 스트림에 기록될 수 있다. 



예를 들자면 다음과 같은 java class를 **java bean** 이라고 한다

```java
import java.io.Serializable;

public class Human implemnts Serializable {
  private String name;
  private int age;
  
  public Human() { /* no argument constructor */}
  
  public String getName() { return name; }
  
  public void setName(String name) { this.name = name; }
  
  public int getInt() { return age; }
  
  public void setAge(int name) { this.age = age; }
}
```



출처 : 

* [stack-overflow Java Bean이 무엇인가 ](https://stackoverflow.com/questions/3295496/what-is-a-javabean-exactly)
* [우아한 형제들 자바 직렬화와 역직렬화](https://techblog.woowahan.com/2550/)

