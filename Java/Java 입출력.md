# JAVA 입출력

* [1. 표준 입출력](#표준-입출력)
  * [입출력 스트림](#입출력-스트림)
  * [Scanner](#Scanner)
* [2. 파일 입출력](#파일-입출력)



## 표준 입출력

알고리즘에서 scanner는 처리 시간이 오래걸린다. 이를 해결하기 위해 인풋스트림을 사용한다.

```java
import java.io.InputStream;

main () throws IOException {
  InputStream in = System.in;
    
  int a = 0;
  a = in.read();
  
  System.out.print(a);
}
```



### 입출력 스트림

**중요한 것은 flush와 close의 사용**

```java
InputStream in = System.in;
InputStreaReader reader = new InputStreamReader(in);

BufferedReader br = new BufferedReader(reader);
String str = br.readLine();

// 입력의 개수가 너무 많을 때 빠른 처리를 위해 사용 (코테)
// 필요하면 아래와 같이 입력 객체를 생성해서 처리
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// 출력할 내용이 많은 경우 BufferedWriter 사용 (코테)
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write("출력");
bw.flush(); // 바로바로 출력이 필요한 경우 플러시 (메모리 비우는 명령)
bw.newLine();
```

#### BufferedWriter.write()

`bw.write()` 의 경우 문자열을 출력하는데 만약 `paremeter` 로 `int` 형이 제공되면 10진 ascii 코드의 값을 출력하게 된다.

따라서 숫자를 출력하기 위해선 다음과 같이 문자열로 형변환을 해주어야한다.

```java
int a = 10;
// 1. Integer.toString() 이용
bw.write(Integer.toString(a));
// 2. String.valueOf() 이용
bw.write(String.valueOf(a));
// 3. 개행 문자를 붙여줌으로써 자동 형변환을 이용
bw.write(a + "\n");
```



```java
InputStream in = System.in;
OutputStream out = System.out;
InputStreamReader reader = new InputStreamReader(in);
OutputStreamWriter writer = new OutputStreamWriter(out);
BufferedReader br = new BufferedReader(reader);
BufferedWriter bw = new BufferedWriter(writer);

// 하나로 묶어서 다음과 같은 형태로 사용
BufferedReader br = new BufferedReader(new InputStreadReader(System.in));
BufferedWriter bw = new BufferedWriter(new OutputStreamReader(System.out));
```



### Scanner

```java
Scanner sc = new Scanner(System.in);

sc.next(); // 한 단어
sc.nextLine(); // 라인 입력
sc.nextInt(); // 정수 입력
```



## 파일 입출력

* 경로 (Path)
  * 폴더나 파일이 있는 위치를 한 줄의 문자열로 표현
  * 일반적으로 파일의 구조는 계층적 구조로 표현(상위ㅡ 하위)
  * 맥 기준 절대경로 (/usr/)



```java
// 파일 입출력 스트림을 객체로 열어준다.
// 기존에 파일이 존재하면, 기존 파일은 삭제되고 새로 만들어짐 (주의)
final String path = "/Users/seungjun/Workspace/Java2/sample.md";

FileOutputStream output = new FileOutputStream(path);


// 문자 리터럴 타입의 String 타입
// 네트워크/파일 에서의 입/출력은 String 사용불가
// Byte 타입만 가능
output.write("파일에 기록중".getBytes());

// 위 사항이 불편하면
FileWriter fw = new FileWriter(path);
fw.write("String 타입인데 기록이 되네\n");
fw.write("줄바꿈 하려면 끝에 개행\n");

// PrintWriter객체의 println메서드를 통해 자동 줄바꿈도 처리해줄 수 있다.
// FileWriter(path, appendMode) 파일의 내용을 덮어쓰지않고 이어서 추가할지 말지 에 대한 속성
FileWriter fw = new FileWriter(path, true);
PrintWriter pw = new PrintWriter(fw);
pw.println("첫 번째 줄");
pw.println("두 번쨰 줄");

// 열려진 출력 스트림을 닫아준다.
// 자바 프로그램이 종료되면 자동으로 닫힘
output.close();
```



### FileInput

```java
// storage로 부터 읽어들인 내용을 저장할 메모리를 미리 정의
byte[] input = new byte[1024];

//  파일 입력 객체(스트림)를 생성
FileInputStream fi = new FileInputStream(path);
fi.read(input);

// 메모리에 저장된 값 출력 
// 위에서 입력받은 input은 byte형태이기 때문에 String으로 형변환을 해줘야함
System.out.println(new String(input));

// 입력 처리가 완료되면 객체(스트림)를 닫아준다.
fi.close();
```



byte를 사용하지 않고 BufferedReader를 사용해 Line 단위로 인풋 읽기

```java
// BufferedReader 객체를 생성
BufferedReader br = new BufferedReader( new FileReader(path) );

// 파일에서 한 라인씩 읽어들이기
// 파일의 전체를 다 읽어오기 위해선 파일의 전체 라인 수 만큼 반복적으로 처리
String line = br.readLine(); // 딱 한줄만 읽음

System.out.println(line);

fi.close();
```



Scanner 이용

```java
// 파일 객체를 생성
File file = new File(path);

// 스캐너는 파일 객체를 읽는다.
Scanner sc = new Scanner(file);

// 파일의 한줄을 읽어서 line에 반환, BufferedReader와 비슷하게 반복문으로 전체를 읽어야함
String line = sc.nextLine();

System.out.println(line);

sc.close();
```

