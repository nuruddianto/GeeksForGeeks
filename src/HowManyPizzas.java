import java.util.*;

public class HowManyPizzas {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int stacks[] = new int[20];
		
		for(int a =0; a < T; a++){
			
			for(int b=0; b < 20; b++){
				stacks[b]= sc.nextInt();
			}
			
			int ans =0; 
			
			for(int c =0; c < 10; c++){
				for(int d = 10; d < 20; d++){
					if(stacks[c] == stacks[d] ){
						ans++;
					}
				}
			}

			
			System.out.print(ans);
			
		}
		
		sc.close();
	}
}
