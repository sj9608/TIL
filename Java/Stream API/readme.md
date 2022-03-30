# Java Stream API

JDK8 이상부터 지원하게 된 기능으로 추가적으로 람다식, 함수형 인터페이스 등을 지원하게 되면서 JAVA를 이용해 함수형 프로그래밍을 지원하는 API 들을 제공해주고 있다.

그 중 Stream API 는 데이터를 추상화 하고 처리하는데 **자주 사용되는 함수들이 정의** 되어 있다. (데이터 추상화의 경우 데이터의 종류에 상관 없이 같은 방식으로 데이터를 처리할 수 있다는 것을 의미하며 그에 따라 재사용성을 높일 수 있다는 것을 의미한다.)

## Stream API

* 원본 데이터를 변경하지 않음

  * 원본의 데이터로부터 읽기만 할 뿐이며, 정렬이나 필터링 등의 작업은 별도의 Stream 요소들에서 처리가 된다.

* 일회용

  * Stream API는 한번 사용이 끝나면 Stream 이 닫혀 재사용이 불가능
  * 만약 닫힌 Stream 을 다시 사용한다면 llegalStateException 발생
  * 필요한 경우 Stream 을 다시 생성해서 사용

* 내부 반복으로 작업 처리

  * Stream 내부의 반복 메서드가 호출이 되어 기존의 for, forEach 보다 간결하게 작성가능
  * `Stream.forEach(System.out::println);`

  

## Stream API Operation

Stream 은 데이터를 처리하기 위해 여러가지 연산을 제공하는데 크게 3가지 단계로 나눌 수 있다.

* **생성**, **가공**, **결과처리**



### 생성

* 말 그대로 생성하는 단계

### 가공

* 원본의 데이터를 Stream 데이터로 가공하기 위한 중간 연산
* 연산 결과를 Stream으로 반환하기 때문에 메서드 체이닝을 이용해 연산을 이어서 할 수 있다.

### 결과 처리

* 가공된 데이터로부터 원하는 결과를 만들기 위한 최종연산

```java
List<String> nums = Arrays.asList("4", "1", "5", "3", "2");

nums.stream() // 생성
    .sorted() // 가공
    .forEach(System.out::println); // 결과처리
```





References:

* [Stream API 망나니개발자](https://mangkyu.tistory.com/112?category=872426)