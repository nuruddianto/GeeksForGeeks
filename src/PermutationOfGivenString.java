import java.util.*;

public class PermutationOfGivenString {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int a =0; a < T; a++){
			String S = sc.next();
			doPermutation("", S);
			System.out.println();
		}
		
		sc.close();
	}
	
	static void doPermutation(String prefix, String str){
		int n = str.length();
		if(n == 0){
			System.out.print(prefix + " ");
		}else{
			for(int i=0; i < n; i++){
				doPermutation(prefix + str.charAt(i), str.substring(0, i)+str.substring(i+1,n));
			}
		}
	}
}
