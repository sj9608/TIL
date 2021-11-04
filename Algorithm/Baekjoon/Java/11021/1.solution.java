import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    int sum = 0;
    int a, b = 0;

    for (int i = 1; i <= t; i++) {
      String line = br.readLine();
      a = Integer.parseInt(line.split(" ")[0]);
      b = Integer.parseInt(line.split(" ")[1]);
      sum = a + b;
      bw.write("Case #" + i + ": " + sum + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}

