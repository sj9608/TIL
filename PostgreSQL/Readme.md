# PostgreSQL

### 기능

PostgreSQL은 관계형 DBMS의 기본적인 기능인 트랜잭션과 ACID(Atomicity, Consistency, Isolation, Durability)를 지원한다.

<br>

### 내부구조

프로세스 구조

1) Shared Memory

- Shared Buffer : Disk I/O를 최소화하는 것이 목적. 그를 위해 매우 큰 버퍼를 빠르게 액세스 해야하고, 다수의 사용자가 동시에 접근할 때 경합을 최소화해야 하며, 자주 사용되는 블록은 최대한 오랫동안 버퍼내에 있어야 함 
- WAL Buffer : 데이터베이스의 변경사항을 잠시 저장하는 버퍼로 wal 버퍼 내에 저장된 내용은 정해진 시점에 wal 파일로 기록. 백업 및 복구 관점에서 wal파일은 매우 중요하고, 오라클에서 Redo의 개념과 비슷

<br>


![image](https://user-images.githubusercontent.com/52594760/156506076-2cffe4ef-7a39-4a37-bfad-93670b9b5c60.png)

1. 클라이언트는 인터페이스 라이브러리(libpg, JDBC, ODBC 등의 다양한 인터페이스)를 통해 서버와의 연결을 요청
2. Postmaster 프로세스가 서버와의 연결을 중계
3. 클라이언트는 할당된 서버와의 연결을 통해 질의를 수행

<br/>

### 서버 내부에서의 질의 수행과정

![image](https://user-images.githubusercontent.com/52594760/156506487-9c43f03a-455b-4398-a37c-76efa6be0503.png)

<br>

1. 클라이언트로부터 질의 요청이 들어오면 구문 분석
2.  Parse Tree를 생성하고 의미 분석과정을 통해 새로운 트랜잭션을 시작하고 Query Tree를 생성
3.  이후 서버에 정의된 Rule에 따라 Query Tree가 재 생성
4. 실행 가능한 여러 수행 계획 중 가장 최적화된 Plan Tree를 생성
5. 서버는 이를 수행하여 요청된 질의에 대한 결과를 클라이언트로 전달

<br/>

### 데이터 타입

[PostgreSQL Data Types 공식문서 보기](https://www.postgresql.org/docs/9.5/datatype.html)

큰 카테고리로 20가지 종류가 존재한다. json 타입, money 타입 등 MySQL 에서 정수형 타입에 AI (Auto Increment) 설정을 하는 것이 아니라 자체적으로 **serial** 타입이 존재하며 그 역할을 대신한다.

| Name         | Aliases | Description                               |
| ------------ | ------- | ----------------------------------------- |
| serial       |         | Auto Increment 4 bytes Integer            |
| integer      |         | signed 4 byte integer                     |
| boolean      |         | true , false                              |
| varchar(n)   |         | 가변길이 문자형                           |
| varchar(n)[] |         | 가변길이 문자형 배열                      |
| Text         |         | 가변길이 문자형, 글자 수가 많은 곳에 사용 |
| Date         |         | 달력 날짜 (year, month, date)             |

<br>

### 몇 가지 특이한 자료형

#### 날짜 / 시간 데이터 타입

**PostgreSQL은 `::자료형` 과 같은 명시로 자료형을 지정할 수 있다.**

```sql
select now() ::timestamp as t;
             t
----------------------------
 2022-03-03 17:16:46.846383

select now() ::date as t;
     t
------------
 2022-03-03

select now() ::time as t;
        t
-----------------
 17:21:13.112326
```

추가적으로 interval 타입은 year, month, day, hour, minute, second 등 단위와 결합하여 시간의 연산이 가능하다. **날짜 연산은 단골기능이므로 익혀 두도록 하자**

```sql
select now() ::timestamp as date1,
	now() + interval '3 day' as date2;
	
           date1            |             date2
----------------------------+-------------------------------
 2022-03-03 17:22:32.679542 | 2022-03-06 17:22:32.679542+09
```



#### 문자형 데이터타입

char, varchar, text 등의 자료형을 사용하면 된다. char, varchar의 경우 문자의 크기를 미리 지정해야한다. char의 경우 고정길이, varchar는 가변길이의 타입. **PG에서의 주의점** char(10) 에서의 "10" 은 10 byte가 아닌 **10 length** 를 의미한다. 즉 10자리의 한글이 입력 가능하다



#### 숫자형 데이터 타입

위에서 언급한 것처럼 많은  숫자형 데이터 타입이 있는데 실제로는 int, numeric 등을 많이 사용한다. 
상황에 맞게 데이터 타입을 선택할 것 !



#### 시리얼 타입

PostgreSQL 에서는 AI 가 지원되는 **Sequence** 라는 타입을 지원하고 있다.

테이블 생성시 아래와 같이 serial 키워드를 이용해 컬러의 타입을 정의함으로써, Sequence 타입을 사용할 수 있다.

```sql
CREATE TABLE table_name(
	id SERIAL
);
```

serial 타입은 postgreSQL 에서 지원하는 타입이므로, 내부적으로 실행될 때는 아래와 같은 SQL 로 바뀌게 된다.

```sql
CREATE SEQUENCE table_name_id_seq;

CREATE TABLE table_name (
    id integer NOT NULL DEFAULT nextval('table_name_id_seq')
);

ALTER SEQUENCE table_name_id_seq
OWNED BY table_name.id;
```

보통 AI 기능은 PK와 같이 사용 되므로 다음과 같은 방식으로 많이 작성한다.

```sql
create TABLE user(
	userNo SERIAL PRIMARY KEY,
    userName varchar NOT NULL
);
```



<br><br>

출처

* [네이버 D2 : 한눈에 살펴보는 PostgreSQL](https://d2.naver.com/helloworld/227936)
* [[PostgreSQL] 자료형 (데이터타입) - 기본 by 게으른공장장](https://codecamp.tistory.com/7)
* [PostgreSQL에서 AUTO INCREMENT 사용하기 by semtax](https://semtax.tistory.com/15)
* [[PostgeSql] PostgreSql 구조 by Ssun's](https://ssunws.tistory.com/41)





