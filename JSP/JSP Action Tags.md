# JSP Action Tags

JSP Action Tag 는 페이지간의 흐름을 제어하고 Java Bean을 사용하는 데 사용 된다.

| JSP             | Action Tags Description                                      |
| --------------- | ------------------------------------------------------------ |
| jsp:forward     | 요청과 응답을 다른 리소스에게 포워딩 (전달)                  |
| jsp:include     | 다른 리소스를 include                                        |
| jsp:useBean     | Bean 오브젝트 생성 or 찾기                                   |
| jsp:setProperty | Bean 객체의 속성 값(value of property)을 설정                |
| jsp:getProperty | Bean 객체의 속성 값(value of property)을 출력                |
| jsp:plugin      | 애플릿(ex. notepad, paint 같은 웹페이지 와 함께 사용자측으로 보내질 수 있도록 만든 작은 응용프로그램)과 같은 다른 구성 요소를 포함 |
| jsp:param       | 매개 변수 값을 설정, 대부분 forward, include에서 사용        |
| jsp:fallback    | 플러그인이 작동하는 경우 메시지를 출력할 때 사용 (jsp : plugin에서 사용) |

<br/>

### \<jsp:forward>  Tag

* 현재 페이지에서 다른 페이지로 전환

```jsp
<jsp:forward page="pageToForward.jps"/>
```

<br><br>

### \<jsp:param> Tag

* forward, include 태그에서 데이터를 전달하기 위해 사용
* name, value 로 구성

```jsp
<jsp:forward page="forwardId.jsp">
	<jsp:param name="id" value="gil-dong" />
</jsp:forward>
```

```jsp
// forwardId.jsp
// get value of name is "id" 

String id = request.getParameter("id");
```





### \<jsp:include> Tag

| 구분        | \<jsp:include>                           | <%@ include %>                                               |
| ----------- | ---------------------------------------- | ------------------------------------------------------------ |
| 형식        | <jsp:include page="..." />               | <%@ include file="..." %>                                    |
| 처리 시점   | 런타임                                   | 컴파일                                                       |
| 기능        | 별도의 파일로 처리 include 메서드 호출   | 현재 파일에 삽입 (컴파일 할 때 하나의 java파일로 생성됨)     |
| 데이터 구성 | 동적 페이지에 더 좋음                    | 정적 페이지에 더 좋음                                        |
| 용도        | 화면 레이아웃 모듈화 할 때 (top, bottom) | 여러 페이지에서 사용하는 변수를 지정하고 include 시킬 때 유리함 |



## Java Bean Related Tag

Java Bean 과 관련된 태그들

* **\<jsp:useBean>** 
  * 자바 빈 을 JSP 페이지에서 이용할 때 사용
* **\<jsp:setProperty>**
  * 빈의 프로퍼티 값을 설정할 때 사용 (데이터 저장)
* **\<jsp:getProperty>**
  * 빈의 프로퍼티 값을 가져올 때 사용



### \<jsp:useBean> Tag

```jsp
<jsp:useBean id="Bean name" class="패키지.클래스" scope="유효범위" />

// example
<jsp:useBean id="student" class="pack01.StudentBean" scope="page" />
```

* id : **자바 빈 이름**
* class : 패키지 명을 포함한 **클래스 이름**
* scope : 자바 빈의 **유효 범위**

| scope 값    | 설명                                                         |
| ----------- | ------------------------------------------------------------ |
| page        | default값으로 생성된 페이지 내에서만 사용 가능               |
| request     | 요청이 수행되는 페이지에서만 사용 가능                       |
| session     | 객체가 생성된 세션에서 수행되는 페이지에서 사용 (웹 브라우저의 lifecyle 과 동일) |
| application | 객체가 생성된 애플리케이션에 포함된 페이지에서 사용 (웹 애플리케이션의 lifecyle 과 동일) |

<br><br>

### \<jsp:setProperty> Tag

```jsp
<jsp:setProperty name="Bean name" property="property name" value="value" />

// example
<jsp:setProperty name="student" proeprty="stdNo" value="2021001" />
```

<br><br>

### \<jsp:getProperty> Tag

```jsp
<jsp:getProeprty name-"Bean name" property="property name" />

// example
<jsp:getProperty name="student" proeprty="stdNo" />

// expected output : "2021001"
```

