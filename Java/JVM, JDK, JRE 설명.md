# JVM, JDK, JRE

세 키워드애 대해 알아보자.



## JVM

**Java Virtual Machine** 의 약자이다.

* JVM은 자바 소스코드로 부터 만들어지는 **자바 바이트 코드를 실행**할 수 있다.
* JVM은 플랫폼에 의존적이다
  * 리눅스 JVM, 윈도우 JVM에 따라 다르다.
* 단, **컴파일 된 바이트코드**는 어떤 JVM 에서도 동작시킬 수 있다.



### JVM의 역할

* 자바 애플리케이션을 클래스 로더를 통해 읽어 들여 자바 API와 함께 실행.
* JVM은 자바와 OS 사이의 중개자 역할을 하며 OS에 독립적인 플랫폼을 갖게 해준다.
  * OS의 메모리 영역에 직접 접근하는 것이 아닌 JVM이라는 가상 머신을 이용해 간접적으로 접근
* JVM은 프로그램의 메모리 관리를 알아서 해준다.



### 자바 프로그램 실행 과정

1. 프로그램이 실행되면 JVM은 OS로 부터 해당 프로그램이 필요로 하는 메모리를 할당받는다.
2. 자바 컴파일러(javac)가 자바 소스코드 (.java) 를 읽어서 자바 바이트코드 (.class)로 변환시킨다.
3. 클래스 로더를 통해 class 파일들을 JVM으로 로딩한다.
4. 로딩된 class 파일들은 Execution engine을 통해 해석된다.
5. 해석된 바이트코드 (.class)는 Runtime Data Areas에 배치되고 수행이 이루어지게 된다. 이러한 과정속에 JVM은 필요에 따라 GC 같은 관리 작업을 수행한다.

<img src="https://hanul-dev.netlify.app/static/58da7d76d6a2d6b85b78337a837a6c07/7de01/jvm.png"/>



본문의 출처 및 상세설명  [[자바 가상머신이란 무엇인가?] JVM에 대해 더 자세한 설명](https://hanul-dev.netlify.app/java/%EC%9E%90%EB%B0%94%EA%B0%80%EB%A8%B8%EC%8B%A0(jvm)%EC%9D%B4%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80/)



## JRE

**Java Runtime Environment**

* JVM, Java Class Library, Java command 및 기타 인프라를 포함

* 컴파일된 자바 프로그램을 실행하는데 필요한 패키지

  

## JDK

**Java Development Kit** 의 약자.

* Java 환경에서 돌아가는 프로그램을 개발하는 데 필요한 툴들을 모아놓은 소프트웨어 패키지이다.
* JRE 와 javac, Java debugger 등을 포함하는 개발 도구들로 이루어짐 (JRE를 포함)

