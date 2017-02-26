package dp;

import java.util.Scanner;

/**
 * Created by SRIN on 2/13/2017.
 */
public class LongestIncreasingSubsuquence {
    private static int arr[];
    private static int n;
    private static int maxLength;
    private static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            n = sc.nextInt();
            arr = new int[n];
            memo = new int[n];
            maxLength = 1;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print(findMaxLength(n));
            t--;
        }
    }

    private static int findMaxLength(int n) {

        for (int k = 0; k < n; k++) {
            memo[k] = 1;
        }

        maxLength = memo[0];
        for (int end = 0; end < n; end++) {
            for (int start = end; start >= 0; start--) {
                if (arr[start] < arr[end] && memo[start] + 1 > memo[end]) {
                    memo[end] = memo[start] + 1;
                    if (memo[end] > maxLength) {
                        maxLength = memo[end];
                    }
                }
            }
        }

        return maxLength;
    }
}

       /*
        1
        5
        3 10 2 1 20
        output 3
        1
        9
        10 22 9 33 21 50 41 60 80
        output 6
        1
        6
        50 3 10 7 40 80
        output 4
        1
        12
        68 35 1 70 25 79 59 63 65 6 46 82
        output 6
        */
