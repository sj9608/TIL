import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int a, b;

    while (true) {
      String line = br.readLine();
      if (line == null) break;
      a = Integer.parseInt(line.split(" ")[0]);
      b = Integer.parseInt(line.split(" ")[1]);
      bw.write(a + b + "\n");
    }

    bw.flush();
  }
}