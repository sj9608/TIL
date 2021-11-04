import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    int a, b = 0;

    for (int i = 1; i <= t; i++) {
      String line = br.readLine();
      a = Integer.parseInt(line.split(" ")[0]);
      b = Integer.parseInt(line.split(" ")[1]);

      // 스트링 포맷으로 새로운 문자열을 만들고 출력
      String output = String.format("Case #%d: %d + %d = %d\n", i, a, b, a + b);
      bw.write(output);
    }

    bw.flush();
    bw.close();
    br.close();
  }
}

