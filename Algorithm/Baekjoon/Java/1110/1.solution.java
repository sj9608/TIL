import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(br.readLine());
    int newNum = 0;
    int check = num;
    int temp = 0;
    int count = 0;

    while (true) {
      temp = num / 10 + num % 10;
      newNum = (num % 10) * 10 + (temp % 10);
      count++;
      num = newNum;
      if (newNum == check) break;
    }
    bw.write(count + "\n");
    bw.flush();

  }
}