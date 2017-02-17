package dp;

/**
 * Created by SRIN on 2/8/2017.
 */
public class Fibonacci {

    public static void main(String[] args){
        lookeup = new int[10];
        f = new int[10];
        System.out.println("Fibonacci Top-Down approach : "+fiboTopDown(4));
        System.out.println("Fibonacci Bottom-Up approach : "+fiboBottomUp(4) );
    }



    private static int[] lookeup;
    /**
     * (Top-Down) Dynamic Programming
     */
    private static int fiboTopDown(int n){
        if(lookeup[n] == 0){
            if(n <=1){
                lookeup[n] = 1;
            }else{
                lookeup[n] = fiboTopDown(n-1) + fiboTopDown(n-2);
            }
        }
        return lookeup[n];
    }

    private static int[] f;
    /**
     * (Bottom-Up) Dynamic Programming
     */
    private static int fiboBottomUp(int n){
        f[0] = 1;
        f[1] = 1;
        for(int i =2 ; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
