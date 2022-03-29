# JUnit4 정리



많이 쓰이는 어노테이션 및 메서드 예제 정리

### @Test

* @Test
* @Test(timeout = `?` ) (ms 단위)
* @Test(expected = ..Exception.class)

> @Test 어노테이션이 붙은 메서드를 테스트 한다.
>
> time out의 경우 ms의 단위의 시간안에 실행되면 성공, 아니면 실패
>
> expected 의 경우 해당 Exception 이 발생하면 성공, 아니면 실패



### @Before, @After

* @Befroe
* @BeforeClass
* @After
* @AfterClass

> 테스트 전, 혹은 후에 실행되어야 하는 메서드의 앞에 어노테이션을 붙여서 사용한다.
>
> 뒤에 Class가 붙은것은 모든 테스트 전, 혹은 후에 1회 실행
>
> Class가 붙지 않은 어노테이션은 각각의 테스트 메서드를 실행할 때마다 실행 전, 혹은 후 마다 실행



## Method

- void assertEquals(Object expected, Object actual) / assertNotEquals( .. )

두 객체 expected와 actual의 **값**이 (같으면 / 다르면) 테스트 성공

- void assertTrue(boolean condition) / assertFalse(..)

condition의 값이 (true / false) 이면 테스트 성공입니다.

- void assertNull(Object object) / assertNotNull(..)

object가 (null / not null) 이면 테스트 성공입니다.

- void assertSame(Object expected, Object actual) / assertNotSame(..)

expected와 actual이 (같은 객체 / 다른 객체) 이면 테스트 성공입니다.

- void assertArrayEquals(type[] expecteds, type[] actuals)

expecteds와 actuals가 같은 같은 값을 가진 배열이면 테스트 성공입니다.



**References** :

* [자바로 테스트 코드를 작성해보자](https://medium.com/jaehoon-techblog/%EC%9E%90%EB%B0%94%EB%A1%9C-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BD%94%EB%93%9C%EB%A5%BC-%EC%9E%91%EC%84%B1%ED%95%B4%EB%B3%B4%EC%9E%90-2-8c98a883cab7)

* [JUnit4 API Document](https://junit.org/junit4/javadoc/latest/)

