package Algorithm.arrays;

import java.util.Scanner;

public class P4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

        둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

        출력
        각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
         */
        int c = sc.nextInt();

        while (c-- > 0) {
            int n = sc.nextInt();
            int sum = 0;
            int avg = 0;
            float passed = 0;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            avg = sum/n;

            for (int val : arr) {
                if (val > avg) passed++;
            }
            System.out.printf("%.3f%%\n", (passed / n) * 100);
        }

    }
}
