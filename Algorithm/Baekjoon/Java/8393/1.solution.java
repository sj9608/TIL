import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int sum = 0;

    for(int i = 1; i <= n; i++) {
      sum += i;
    }

    // bw.write에서 int는 10진 ascii 코드의 값을 출력 하기 때문에
    // 문자열로 형 변환이 필요하다. String.valueOf( int ) 를 이용하거나 
    // Integer.toSTring( int ) 를 이용해 String 으로 형 변환 해준다.
    // 혹은 편하게 int 뒤에 + "\n" 개행문자를 붙여주면 자동 String 형변환이 된다..;,
    bw.write(String.valueOf(sum));

    bw.flush();
    bw.close();
    br.close();
  }
}

