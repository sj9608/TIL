# Stream API 활용



### Stream Creation



**Collection Stream**

Collection 인터페이스에는 stream()이 정의되어 있기 때문에, Collection 인터페이스를 구현한 객체들 (List, Set 등) 은 모두 이 메서드를 이용해 Stream 을 생성할 수 있다.

```java
// List 로 부터 Stream 생성
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> listStream = list.stream();
```



**Array Stream**

배열의 원소의 Stream을 생성하기 위해서는 Stream의 of 메소드 또는 Arrays 의 Stream 메서드를 사용하면 된다.

```java
// Array Stream 생성
Stream<String> stream = Stream.of("a", "b", "c");
Stream<String> stream = Stream.of(new String[] {"a", "b", "c"});
Stream<String> stream = Arrays.stream(new String[] {"a", "b", "c"});
Stream<String> stream = Arrays.stream(new String[] {"a", "b", "c"}, 0, 3); // 0, 1, 2
```

