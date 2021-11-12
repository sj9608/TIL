package Algorithm.arrays;

import java.util.Scanner;

public class P3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] diff = new boolean[42];

        for (int i = 0; i < 10; i++) {
            diff[sc.nextInt() % 42] = true;
        }

        int cnt = 0;
        for (int i = 0; i < 42; i++) {
            if (diff[i]) cnt++;
        }

        System.out.println(cnt);
    }
}
