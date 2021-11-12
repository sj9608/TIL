package Algorithm.arrays;

import java.util.Scanner;

public class P1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float total = 0;
        float best = 0;
        int n = sc.nextInt();
        float[] arr = new float[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextFloat();
            if (arr[i] > best) best = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] / best) * 100;
            total += arr[i];
        }

        float avg = total / n;
        System.out.printf("%.3f", avg);
    }
}
