import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str2 = br.readLine();
    
    int n = Integer.parseInt(br.readLine());
    int sum = 0;

    for(int i = 1; i <= n; i++) {
      bw.write(); // 10진수 아스키코드 값 출력  'A'
      bw.write(Integer.toString(i));
      bw.write(String.valueOf(i));
      bw.write(i + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}

