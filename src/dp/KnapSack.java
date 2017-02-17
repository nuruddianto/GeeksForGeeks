package dp;

import java.util.Scanner;

/**
 * Created by SRIN on 2/9/2017.
 */
public class KnapSack {
    private static int[] values;
    private static int[] weights;
    private static int N;
    private static int memo[][];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T != 0){
            N = sc.nextInt();

            values = new int[N];
            weights = new int[N];

            int maxWeight = sc.nextInt();
            memo = new int[maxWeight+1][N+1];
            for(int i =0; i < N; i++){
                values[i] = sc.nextInt();
            }

            for(int i =0; i < N; i++){
                weights[i] = sc.nextInt();
            }

            //System.out.println(findMaxValueTopDown(maxWeight,N));
            System.out.println(findMaxValueBottomUp(maxWeight,N));

            T--;
        }
    }

    private static int findMaxValueTopDown(int maxWeight, int n){
        if(memo[maxWeight][n] == 0){
            if(n == 0 || maxWeight <= 0){
                return 0;
            }
            if(weights[n-1] > maxWeight){
                memo[maxWeight][n] = findMaxValueTopDown(maxWeight, n-1);
            }else{
                memo[maxWeight][n] =  max(values[n-1] + findMaxValueTopDown(maxWeight - weights[n-1], n-1), findMaxValueTopDown(maxWeight, n-1));
            }
        }
        return  memo[maxWeight][n];
    }


    private static int findMaxValueBottomUp(int maxWeight, int n){

        if(n <= 0 || maxWeight <= 0){
            return 0;
        }
        for(int i = 1; i <= n; i++){
            memo[maxWeight][i] = max(values[n-1] + findMaxValueBottomUp(maxWeight - weights[n-1], n-1), findMaxValueBottomUp(maxWeight, n-1));
        }
        return memo[maxWeight][n];
    }
    private static int max(int a, int b){
        return (a > b)? a : b;
    }
    /*
    1
    3
    50
    60 100 120
    10 20 30
    */

}
