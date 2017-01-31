import java.util.*;

public class SumOfPermutation {		
	public static void main(String[] args) {
		permutation("", "abc");
		String s = "abc";
		System.out.print(s.substring(1, 2));
		//System.out.print(s.charAt(0));
		//System.out.print(s.length());
	}
	
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0){
	    	System.out.println(prefix);
	    	//System.out.println();
	    }	    	
	    else {
	        for (int i = 0; i < n; i++){
	        	//System.out.print(i+" ");
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	        	
	    }
	}

}
