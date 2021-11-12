package Algorithm.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int sum = 1;
        for (int i = 0; i < 3; i++) {
            sum *= sc.nextInt();
        }

        String sumStr = Integer.toString(sum);
//        for (int i = 0; i < sumStr.length(); i++) {
//            for (int j = 0; j < 10; j++) {
//                if (sumStr.charAt(i) == 48 + j) arr[j]++;
//            }
//        }
//

//        while (sum > 0) {
//            arr[sum % 10]++;
//            sum /= 10;
//        }

        for (char ch : sumStr.toCharArray()) {
            arr[ch - 48]++;
        }


        System.out.println(Arrays.toString(arr));
    }
}
