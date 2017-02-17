package dp;

import java.util.Scanner;


/**
 * Created by SRIN on 2/13/2017.
 */
public class LongestIncreasingSubsuquence {
    private static int arr[];
    private static int n;
    private static int maxLength;
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            n = sc.nextInt();
            arr = new int[n];
            memo = new int[n][n];
            maxLength = 1;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

//            for (int i = 0; i < n; i++) {
//                findMaxLength(i, 1);
//            }
            System.out.print(findMaxLength(n));
            //System.out.print(maxLength);
            t--;
        }
    }

//    private static int findMaxLength(int i, int length) {
//        for (int k = 1 + i; k < n; k++) {
//            if (arr[k] > arr[i]) {
//                findMaxLength(k, length + 1);
//            }
//        }
//
//        if (length > maxLength) {
//            maxLength = length;
//        }
//        return length;
//    }

    private static int findMaxLength(int n) {
        maxLength = 0;
        int maxInt = arr[0];
        for (int end = 0; end < n; end++) {
            for (int start = end; start >= 0; start--) {
                if (end == start) {
                    memo[start][end] = 1;
                    maxInt = arr[start];
                } else {
                    if (arr[start] >= arr[end]) {
                        maxInt = arr[start];
                        memo[start][end] = memo[start+1][end];
                    } else {
                        memo[start][end] = memo[start+1][end ] + 1;
                    }

                    if (memo[start][end] > maxLength) {
                        maxLength = memo[start][end];
                    }
                }
                //System.out.print(start + "," + end + " ");
                //System.out.print(maxLength+" ");
                System.out.print(maxInt+" ");
                //System.out.print(memo[start][end] + " ");

            }
            System.out.println();
        }

        for (int end = 0; end < n; end++) {
            for (int start = end; start >= 0; start--) {
                System.out.print(start + "," + end + " ");
                //System.out.print(maxInt+" ");
            }
            System.out.println();
        }

        for (int end = 0; end < n; end++) {
            for (int start = end; start >= 0; start--) {
//                System.out.print(start + "," + end + " ");
                System.out.print(memo[start][end] + " ");
            }
            System.out.println();
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
