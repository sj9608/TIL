# [Spring] @ResponseBody, @RestController



Spring framework 에서 rest API 를 설계하기 위해서 @Controller Annotation 메서드에 @ResponseBody 를 사용하거나 혹은 컨트롤러 클래스에 @RestController Annotation 을 사용 할 수 있다.

> 여기서 rest 란 분산 하이퍼 미디어 시스템(웹) 을 위한 아키텍쳐 스타일 이다
>
> **RE**presentational **S**tate **T**ransfer 상태 전송을 대표가능한 API 를 REST API 라고 한다.
>
> 다만 위에서 말했듯이 아키텍쳐 스타일을 따라야하는데 아키텍쳐 스타일은 제약조건들의 집합이라고 보면 된다. 자세한 내용은 [그런 REST API로 괜찮은가?](https://github.com/sj9608/TIL/blob/master/Javascript/REST%20API.md) 참조



## 스프링 MVC 프레임 워크와 REST

일반적인 Spring MVC 컨트롤러와 RESTful 웹 서비스 컨트롤러의 주요 차이점은 HTTP 응답 바디가 생성되는 방식이다.

* 일반적인 MVC 컨트롤러는 View 로 응답한다.
* RESTful 웹 서비스 컨트롤러는 객체(JSON, XML 등)를 반환하면 JSON이나 XML 형식의 HTTP 응답에 직접 작성된다.



### 스프링에서 REST하게 데이터가 송수신 되는 과정

1. 클라이언트에서 웹서비스에 요청을 보낸다.
2. Handler Mapping 과 그 타입을 찾는 Dispatcher Servelt 이 요청을 가로챈다.
3. 해당 요청은 Controller 에 의해 처리되고 응답은 Dispatcher Servlet 으로 반환된다.
4. Dispatcher Servlt 은 다시 View 로 보낸다.



#### @ResponseBody

* 메서드에 @ResponseBody 어노테이션을 사용하면 Spring이 반환 값을 변환하여 HTTP Response 의 Body에 해당 값을 반환하여 쓰기동작을 한다.



#### @RestController

* Spring 4.0은 @Controller, @ResponseBody 를 합쳐놓은 것 이상의 역할을 수행하는 @RestController 를 추가함.
* 컨트롤러 클래스에 해당 어노테이션을 작성하면 메서드 레벨에서 @ResponseBody가 자동으로 작동한다.