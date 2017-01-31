import java.util.*;

public class WhoWillWin {
	static int N,M,G,S, ansG, ansS;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int a=1; a <= T; a++){
			N = sc.nextInt();
			M = sc.nextInt();
			G = sc.nextInt();
			S = sc.nextInt();		
			
			ansG = G*M-G;
			//System.out.println(ansG);
			checkSubHash(M, N, S);
			if(ansG == ansS ){
				System.out.println(0);
			}else if(ansG < ansS){
				System.out.println(1);
			}else{
				System.out.println(2);
			}
		}
		sc.close();
	}
	
	static int checkSubHash(int M, int N, int S){
		int lo = 1;
		int hi = N;
		while(lo <= hi){
			int mid = lo + (hi -lo)/2;
			//System.out.println(ansS);
			if(M < mid){
				ansS += S;
				hi = mid - 1;
			}else if(M > mid){
				ansS += S;
				lo = mid +1;
			}else{
				return ansS;
			}
		}
		
		return -1;
	}
	
}
