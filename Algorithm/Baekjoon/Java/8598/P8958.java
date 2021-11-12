package Algorithm.arrays;

import java.util.Scanner;

public class P8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String str = sc.next();
            int totalScore = 0;
            int score = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'O') {
                    score++;
                    totalScore += score;
                } else {
                    score = 0;
                }
            }
            System.out.println(totalScore);

        }
    }
}
