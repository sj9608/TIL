import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int a, b;

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      a = Integer.parseInt(str.split(" ")[0]);
      b = Integer.parseInt(str.split(" ")[1]);
      bw.write(a + b + "\n");
    }
    bw.flush();
    br.close();
    bw.close();
  }
}
