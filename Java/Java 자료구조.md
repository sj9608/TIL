# Java 자료구조



## HashMap

* Map 인터페이스를 구현한 대표적인 Map 컬렉션이다.
* Map 인터페이스를 상속하고 있다.
* Map은 Key, Value로 이루어진 Entry 객체를 저장하는 구조를 가지고 있다.
* HashMap은 말 그대로 Hash를 이용하는 Map 이기 때문에 데이터를 검색하는데 뛰어난 성능을 지니고 있다.



### HashMap 사용법

```java
HashMap<String, Integer> hash = new HashMap<String, Integer>();
HashMap<String, Integer> hash2 = new HashMap<>(); // new의 타입파라미터 생략 가능

// 해쉬맵 복사
HashMap<String, Integer> hash3 = new HashMap<>(hash1) // hash의 모든 값을 복사해서 생성함
```

* HashMap을 생성하려면 키 타입과 값 타입을 타입 파라미터로 주고 기본 생성자를 호출하면 된다.
* HashMap은 저장공간(`capacity`)보다 값이 추가로 들어오면 저장공간을 약 2배 가량 늘린다.
* 따라서 초기에 저장할 데이터 개수를 알고 있다면 Map�� 초기 용량을 지정해 주는 것이 좋다.

위 내용에 대한 추가 참고 자료 https://d2.naver.com/helloworld/831311



### HashMap 값 추가

```java
HashMap<String, Integer> hash = new HashMap<>();
hash.put("menu", 1000);
```

* HashMap에 값을 추가하려면`put(key, value)` 메서드를 이용한다.
* 입력되는 `key` 가 중복되면 `value` 를 덮어 쓴다.



### HashMap 값 삭제

```java
HashMap<String, Integer> hash = new HashMap<>();

hash.remove("menu"); // key 값이 "menu" 에 해당하는 맵을 삭제한다.
hash.clear(); // 모든 값을제거
```

* 파라미터에 해당하는 key의 맵을 삭제하기 위해선 `remove()` 메서드를 이용한다.
* 모든 값을 제거하고 싶다면 `clear()` 메서드를 이용한다.



### HashMap 값 출력

```java
HashMap<String, Integer> map = new HashMap<>() {{ //초기값 지정
            put("Turky", 5100);
            put("Subdog", 5900);
            put("FoldPork", 5400);
        }};

        System.out.println(map); //전체 출력 : {5100=Turky, 5900="Subdog", 5400=FoldPork}
        System.out.println(map.get("Turky"));// key값 Turky의 value얻기 : 5100

        //entrySet() 활용
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
        }
        //[Key]:"Turky" [Value]:5100
        //[Key]:"Subdog" [Value]:5900
        //[Key]:"FoldPork" [Value]:5400

        //KeySet() 활용
        for (String str : map.keySet()) { //저장된 key값 확인
            System.out.println("[Key]:" + str + " [Value]:" + map.get(str));
        }
        //[Key]:"Turky" [Value]:5100
        //[Key]:"Subdog" [Value]:5900
        //[Key]:"FoldPork" [Value]:5400
}
```

* 단순 print를 이용하게 되면 `{}` 로 묶어 Map의 전체 key 값, value 값이 출력 된다.
* 특정 key값의 value를 가져오고 싶다면 `get(key)` 를 이용하면 된다.
* 전체를 출력하기 위해선 `entrySet()` 혹은 `keySet()` 메서드를 활용하여 Map 객체를 반환 받은 후 출력하면 된다.
* 보통 `entrySet()` 은 `key` 와 `value` 모두 필요할 경우 사용한다.
* 반대로 `keySet()` 은 `key` 값만 필요할 경우 사용하는데 `key` 값과 `get(key)` 메서드를 이용해서 `value` 를 구할 수 있다.
* 다만 `key` 값을 이용해서 `value` 를 찾는 과정에 시간이 많이 소모 되므로 많은 양의 데이터를 가져와야 한다면 `entrySet()`을 활용하자.
* keySet은 entrySet에 비해 20% ~ 200%의 성능 저하가 있다고 한다.



HashMap 설명은 해당 블로그를 참조 했습니다.

* https://coding-factory.tistory.com/556�
