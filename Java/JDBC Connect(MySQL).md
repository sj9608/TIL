# JDBC (Java Database Connectivity)

- 다양한 종류의 관계형 DB에 접근할 때 사용되는 자바 표준 SQL 인터페이스
- 자바 프로그램이 DBMS에 접근하여 작업할 수 있게 해주는 API를 제공하는 클래스 모음
- 모든 DBMS에서 공통적으로 사용할 수 있는 인터페이스와 클래스로 구성
- 실제 구현 클래스는 각 DBMS 벤더가 구현 했기 때문에 거의 모든 벤더가 JDBC 드라이버 제공
- 각 DBMS에 맞는 JDBC 드라이버 사용



## JDBC 드라이버

- JDBC 인터페이스를 구현한 클래스 파일 모음 (jar 파일)
- 각 DBMS 벤더에서 제공되는 구현 클래스



## JDBC의 역할

* 응용 프로그램과 DBMS 사이의 연결 역할
* SQL문을 DBMS에 전달하고 그 결과값을 응용프로그램에서 전달하는 역할

![image](https://user-images.githubusercontent.com/52594760/143262084-bf5087cf-0c71-4cb1-ab92-f681f3b3938c.png)



## JDBC 장점

- 사용하는 RDBMS에 독립적인 프로그래밍 가능
    - JDBC Driver 설정만 하면 다른 DBMS 에서도 벤더가 맞게 DB의 데이터를 읽고 쓸 수 있음
- 쉽게 RDBMS의 교체가 가능하다
- 자바에서 단순히 문자열로 쿼리를 전달하고 해석은 각 벤더가 구현(JDBC Driver에서)
- 표준 SQL 뿐 아니라 각 JDBC Driver를 제공하는 DBMS 벤더별로 최적의 성능 발휘 가능
- 벤더 종속적인 SQL도 처리 가능



## JDBC 사용방법

### (0) package import

> jdbc driver manager, Connection, Statement 등 sql에 사용하는 모든 객체, 메서드에 대한 패키지는 `java.sql` 의 하위 패키지에 모두 포함되어있다.

```java
import java.sql.*;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
```



### (1) JDBC Driver Load

`java.sql.DriverManager` 패키지 `import`

```java
import java.sql.DriverManager;

class Test {
  public static void main(String[] args) {
    Class.forName('com.mysql.cj.jdbc.Driver');
  }
}
```



### (2) Connection 객체 생성

```java
String url = "jdbc:mysql://localhost:3306/test_db";
String user = "root";
String pw = "1234";

Connection connection = DriverManager.getConnection(url, user, pw);
```



### (3) Statement 객체 생성

```java
String query = "select * from test";

Statement statement = connection.createStatement(query);

// PreparedStatement 에 대해 추가정보 필요
```



### (4) Query 수행, (5) ResultSet 객체로 결과 저장
```java
String query = "select * from test";

Resultset resultSet = statement.excuteQuery(query);

```


### (6) Close
`ResultSet`, `PreparedStatement`, `Connection` 순서로 `close()` 메서드를 호출한다. 
```java

resultSet.close();
preparedStatement.close();
connection.close();

```
### 

## Statement Vs PreparedStatement

### Statement
- 문자열(String)로 구성된 SQL문을 DBMS로 전송하면
- 내부적으로 SQL문을 JDBC 드라이버가 읽을 수 있는 형식으로 전처리 수행
- SQL은 실행될 때마다 매번 전처리 작업을 수행해야 하기 때문에 반복적인 작업에서 속도가 늦어질 수 있음
- **쿼리문에 값이 미리 다 입력되어 있어야함**
- 작성하는 SQL문이 복잡해짐

### PreparedStatement
데이터베이스 관리 시스템(DBMS)에서 **동일하거나 비슷한 데이터베이스 문을 높은 효율성으로 반복적으로 실행하기 위해 사용되는 객체**
- Statement 인터페이스의 하위 인터페이스
- SQL은 실행될 때마다 매번 전처리 하지 않고 라이브러리 캐시에서 읽어와서 처리하기 때문에 처리 속도가 빠름
- SQL문 구조는 같지만 조건이 수시로 변할 때 조건의 변수 처리를 `?` (placeholder)로 지정 - 바인딩변수
- 동일한 SQL문을 특정 값만 바꾸어서 여러 번 실행해야 할 때, 또는 인수가 많아서 SQL 문이 복잡할 때 편리
