import java.io.*;
import java.util.ArrayList;

public class ArrayDP {

	public static void main(String args[]){
		
		String input = "1292724121";
		System.out.println(findStrNumber(input));
	}
	
	public static int findStrNumber(String input) { 

		int l = input.length();
		int[] dp = new int[l];
		dp[0] = 1;
		for(int i = 1 ; i < l ; i++){
		//	System.out.println(dp[i-1]);
			int num = (input.charAt(i-1)-'0')*10+(input.charAt(i)-'0');

			if(num <= 25){
				if(i>1){dp[i] += dp[i-2] + dp[i-1];System.out.println(dp[i]);}
				else {dp[i] = 2;}
			}else{
			dp[i] += dp[i-1];
	//		System.out.println(dp[i]);
		}
		}
		return dp[l-1];
	} 
}

