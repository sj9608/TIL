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



```java
InputStream in = System.in;
OutputStream out = System.out;
InputStreamReader reader = new InputStreamReader(in);
OutputStreamWriter writer = new OutputStreamWriter(out);
BufferedReader br = new BufferedReader(reader);
BufferedWriter bw = new BufferedWriter(writer);
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
FileWriter fw = new FileWriter(path, true);
PrintWriter pw = new PrintWriter(fw);
pw.println("첫 번째 줄");
pw.println("두 번쨰 줄");

// 열려진 출력 스트림을 닫아준다.
// 자바 프로그램이 종료되면 자동으로 닫힘
output.close();
```





