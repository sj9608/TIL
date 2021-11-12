package Algorithm.arrays;

import java.util.Scanner;

public class P2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int max = 0;
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        System.out.printf("%d %d", max, idx);

    }
}
