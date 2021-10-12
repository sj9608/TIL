# 그런 REST API로 괜찮은가

> 해당 포스트는 [그런 REST API로 괜찮은가](https://youtu.be/RP_f5dMoHFc ) 의 내용들을 정리한 글입니다.

## REST

REST는 **RE**presentational **S**tate **T**ransfer 의 약자

컴퓨터 시스템간 상호운용성을 제공하는 방법중 하나

> 이게 뭔소리여

## REST의 역사

### WEB (1991)

> Q: 어떻게 인터넷에서 정보를 공유할 것인가?
>
> A: 정보들을 하이퍼 텍스트로 연결한다.
>
> 표현형식 : HTML
>
> 식별자 : URI 
>
> 전송방법 : HTTP

웹에서 정한 규칙 

### HTTP/1.0 (1994-1996) 

HTTP 프로토콜을 설계할 당시 이미 World Wide Web의 전송 프로토콜로 이미 이용되고 있었는데 HTTP를 정립하고 명세에 기능을 더하고 기존의 기능을 고쳐야 하는 상황에 놓였을 때 HTTP프로토콜을 수정하게 되면 기존 웹에서 사용되는 HTTP와 호환성의 문제가 생길것 같아서 해결책으로 **HTTP Object Model**을 설계했다.  4년 뒤에 **HTTP Object Model**을 **REST**라는 이름으로 발표를 하게 되었고 그로 부터 2년뒤에 박사 논문으로 발표를 하게된다.



### Mircrosoft REST API Guidelines (2016)

* uri는 https://{seveiceRoot}/{collection}/{id} 형식 이어야한다.
* GET, PUT, DELETE, POST, HEAD, PATCH, OPTIONS 를 지원해야 한다.
* API 버저닝은 Major. minor로 하고 uri에 버전 정보를 포함시킨다.
* 등등..

> **필딩 왈** : 이거 REST 아님

일반 사람이 볼 때 REST 같은데 ? 라고 착각할 수 있지만 정작 REST논문을 발표한 필딩이 REST가 아니라고 하자 혼란이 왔다. 그래서 REST가 뭔데!🤬

## 로이필딩이 말하는 REST

>  분산 하이퍼 미디어 시스템(예: 웹)을 위한 아키텍쳐 스타일
>
>  또한 REST는 hyper-text driven 이어야 한다.

## REST API

> <span style="font-size: 24px">REST 아키텍쳐 스타일을 따르는 API</span>

### 아키텍쳐 스타일 ?

제약 조건들의 집합

### REST를 구성하는 스타일

REST는 아키텍쳐 스타일이면서 동시에 아키텍쳐 스타일의 집합인 **하이브리드 아키텍쳐 스타일** 이다.



* client-server (클라이언트 서버 모델)
  * 서비스 요청자인 **클라이언트**와 서비스 자원의 제공자인 **서버**간에 작업을 분리해주는 분산 애플리케이션 구조이자 **네트워크** 아키텍처를 나타낸다. [위키에서 자세히 보기](https://ko.wikipedia.org/wiki/%ED%81%B4%EB%9D%BC%EC%9D%B4%EC%96%B8%ED%8A%B8_%EC%84%9C%EB%B2%84_%EB%AA%A8%EB%8D%B8)
* stateless
  * 기본적인 HTTP의 통신 원칙은 Stateless이다. 클라이언트의 상태를 가지지 않는 서버 처리방식을 말한다. 클라이언트와 첫번 째 통신에서 데이터를 받았다고 해도 두 번째 통신에서 이 데이터를 계승하지 않는 처리방식이다. 하지만 실제 서비스에서는 이와 같은 기본 원칙보다 Stateful한 방식이 필요한 경우가 많다. Stateful 하게 만들기 위해 쿠키와 세션이 존재한다.  [위키에서 자세히 보기](https://ko.wikipedia.org/wiki/%EB%AC%B4%EC%83%81%ED%83%9C_%ED%94%84%EB%A1%9C%ED%86%A0%EC%BD%9C)
* cache
  * 캐시의 기본개념인 이미 가져온 데이터, 값 등을 저장함으로 처리 속도를 향상시키기 위한 자원
  * 웹 캐시는 사용자(클라이언트)가 웹 사이트(서버)에 접속할 때, 정적 컨텐츠 (img, js, css)를 특정 위치(client, network 등)에 저장하여 사이트 응답 시간을 줄이고 서버트래픽을 감소시키기 위한 아키텍쳐 스타일
  * [토스 기술 블로그 [웹 서비스 캐시 똑똑하게 다루는 방법]](https://toss.tech/article/smart-web-service-cache)
* layered system
* code-on-demand (optional)
  * server 에서 code를 client로 보내서 실행할 수 있어야한다. (JavaScript)
* **uniform interface**

일반적인 HTTP 제약조건만 지켜도 위에 있는 아키텍쳐 스타일은 지켜진다. 단 하나, **uniform interface 제외**

#### Uniform Interface의 제약조건

* identification of resources
  * 리소스가 uri로 식별가능한가
* manipulation of resources through representations
  * 리소스를 만들거나 업데이트 할 떄 표현을 담아서 전송조작을 해야한다.
* **self-descriptive messages**
  * 스스로 설명할 수 있는 메세지 

* **hypermdedia as the engine of application state (HATEOAS)**



#### Self-descriptive messages

```HTTP
GET / HTTP/1.1
```

이 HTTP 요청 메세지는 뭔가 빠져있어서 self-descriptive 하지 못하다. 아래와 같이 목적지를 추가해줘야한다.

```HTTP
GET / HTTP/1.1
HOST: www.example.org
```



우리가 보기엔 아래의 내용이 json 이라는것을 유추할 수 있지만 서버에서 해석할 수 없다. 

```HTTP
HTTP/1.1 200 OK
[ { "op": "remove",
"path": "/a/b/c" } ]
```

아래와 같이 Content-Type을 표기해줘야한다.

```HTTP
HTTP/1.1 200 OK
Content-Type: application/json

[ { "op": "remove",
"path": "/a/b/c" } ]
```

이 또한 op와 path가 무엇을 의미하는지 모르기 때문에 완전히 Self-descriptive message라고 보기 어려움. 

```HTTP
HTTP/1.1 200 OK
Content-Type: application/json-patch+json

[ { "op": "remove",
"path": "/a/b/c" } ]
```

#### HATEOAS

애플케이션의 상태가 Hyperlink를 통해 전이되어야 한다.

```http
HTTP/1.1 200 OK
Content-Type: application/json

<html>
<head></head>
<body>
	<a href="/test">test</a>
</body>
</html>
일반적인 html은 HATEOAS를 만족한다.
```



### 왜 Uniform interface가 필요한가?

<a style="font-size:28px">독립적 진화</a>

* 서버와 클라이언트가 각각 독립적으로 진화한다.
* **서버의 기능이 변경되어도 클라이언트를 업데이트 할 필요가 없다.**
* REST를 만들게 된 계기 : "How do I improve HTTP without breaking the Web" 

> 웹 규칙을 깨지않고 HTTP 명세를 향상시키지? 에 대한 고민

따라서 유니폼 인터페이스를 지키지 않으면 REST하지 못하다고 할 수 있다. **중요**



### 웹

* 웹 페이지를 변경해도 웹 브라우저를 업데이트할 필요 없음
* 웹 브라우저 업데이트했다고 웹 페이지를 변경할 필요도 없다
* HTTP 명세가 변경되어도 웹은 잘 동작한다.
* HTML 명세가 변경되어도 웹은 잘 동작한다.

REST 명세를 잘 지키면 위 처럼 호환성과 유지가 굉장히 좋아진다.



### 상호 운용성 (interoperability)에 대한 집착

* Referer / 원래 Referrer 지만 이걸 고치면 HTTP 호환성이 깨진다.
* chaset 은 잘못 지은 이름이지만 고치지 않는다 encoding이 맞는 표현



### REST가 웹의 독립적 진화에 도움을 주었나 ??

* HTTP에 지속적으로 영향을 주었고
* Host 헤더가 필요하다고 느껴져 추가함
* 길이 제한을 다루는 방법이 명시
* URI에서 리소스의 정의가 추상적으로 변경됨
* HTTP/1.1 명세 최신판에서 REST에 대한 언급이 들어감 (영향을 많이 주었기 때문에)



우리가 만드는 API는 꼭 REST API여야 하는가?

> 시스템 전체를 통제할 수 있다고 생각하거나, 진화에 관심이 없다면 REST에 대해 따지느라 시간을 낭비하지마라. **필딩왈**

REST 규칙을 지키며 API를 만드는것은 시간이 드는 일이다. 하지만 오래 유지될 수 있는 시스템을 만들고 싶다면 RESTful 하게 제작해라
