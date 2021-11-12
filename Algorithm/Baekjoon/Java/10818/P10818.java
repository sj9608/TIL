package Algorithm.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.printf("%d %d", arr[0], arr[arr.length -1]);
    }
}
