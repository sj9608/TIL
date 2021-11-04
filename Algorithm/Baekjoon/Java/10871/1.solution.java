import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n, x;
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    x = Integer.parseInt(line[1]);

    String[] nums = br.readLine().split(" ");

    for (String num : nums) {
      if (Integer.parseInt(num) < x) {
        bw.write(num + " ");
      }
    }
    bw.flush();
  }
}