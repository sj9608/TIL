package Algorithm.BOJ.Study;

import java.io.*;
import java.util.Arrays;

public class P2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((sum - arr[i] - arr[j]) == 100) {
                    a = arr[i];
                    b = arr[j];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != a && arr[i] != b)
                bw.write( Integer.toString(arr[i]) + "\n");
        }

        bw.flush();

    }
}
