# JAVA HTTP 통신

코드들에 **예외처리가 생략되어 있음**으로 유의 (실제 코드에서 예외처리 안하면 에러)

## GET 방식

### 1. url 객체생성

```java
// import java.net.URL;
String apiURL = "apiURL 주소";

URL url = new URL(apiURL);
```



### 2. HTTP Connection

```java
// import java.net.HttpURLConnection;

HttpURLConnection con = (HttpURLConnection)url.openConnection();

// requestMethod 설정
con.setRequestMehtod("POST"); // GET, POST, UPDATE, DELETE
con.setRequestProperty("X-Naver-Client-Id", clientId); // 헤더 설정
```



### 3. 응답 확인

```java
// import java.io.BufferedReader;
// import java.io.InputStreamReader;

int responseCode = con.getResponseCode();
BufferedReader br;

if (responseCode == 200) { // 정상응답
    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
} else {
    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
}

String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = br.readeLine()) != null) { // 한줄한줄 읽기
    response.append(inputLine);
}

br.close();

System.out.println(response.toString); // 응답 String으로 변환

```



## POST 방식

### 1. URL 객체 생성

```java
String text = URLEncoder.encode("안녕하세요", "UTF-8"); // 한글 Encoding to URL
String apiURL = "apiURL";

URL url = new URL(apiURL);
```



### 2. URL Connection

```java
HttpURLConnection con = (HttpURLConnection) url.openConnection();

con.setRequestMethod("POST");
con.setRequestProperty("X-Naver-Client-Id", clientId);
con.setDoOutput(true); // 출력에 URL 연결을 사용하려는 경우 true
```



### 3. outpuStream

GET 방식과의 차이점은 outputStream으로 url에 parameter 를 보내는가 

```java
DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
outputStream.writeBytes(postParams);
outputStream.flush();
outputStream.close();
```



### 4. response

```java
int responseCode = con.getResponseCode();

BufferedReader br;

if (responseCode == 200) {
    br =  new BufferedReader(new InputStreamReader(con.getInputStream()));
} else {
    br =  new BufferedReader(new InputStreamReader(con.getErrorStream()));
}

String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = br.readLine()) != null) {
    response.append(inputLine);
}

br.close();

System.out.println(response.toString); // 응답 데이터
```







참고 및 api 상세 내용은 아래의 사이트에서 확인

https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/HttpURLConnection.html



