import java.io.*;
import java.util.ArrayList;

public class DParray {

	public static void main(String args[]){
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(4);
		al.add(2);
		al.add(3);
		System.out.println(myAdjust(al, 1));

	}
	
	public static int myAdjust(ArrayList<Integer> A, int target) { 

		int n = A.size(); 
		int[][] dp = new int[n][101]; 

		for(int i = 0; i < n; i ++) { 
			for(int j = 1; j <= 100; j ++) { 

				if(i == 0) { 
					dp[i][j] = Math.abs(A.get(i) - j); 
				} else { 
					dp[i][j] = 999999;  

					for(int m = 1; m <= 100; m ++) { 
						if(Math.abs(m - j) > target) 
							continue; 

						int diff = Math.abs(A.get(i) - j) + dp[i - 1][m]; 
						dp[i][j] = Math.min(dp[i][j], diff); 
					} 
				} 
			} 
		} 
		
		int minCost = dp[n - 1][1]; 
		for(int i = 2; i <= 100; i ++) { 
			minCost = Math.min(minCost, dp[n - 1][i]); 
		} 

		return minCost; 
	} 


}

