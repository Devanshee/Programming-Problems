import java.util.*;
	public class SpiralMatrix{
		
		static int count = 0;
		static ArrayList<Integer> result = new ArrayList<Integer>();	
		
		public static void main(String[] args){
					
		int[][] mat = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		ArrayList<Integer> a = spiralMat( mat , 5 , 5 ,0,0);
		System.out.println("Result :"+a.size());
		}	
		
	
		
		public static ArrayList<Integer> spiralMat( int[][] mat , int m , int n , int i , int j){			
		
		while(i != m || j != n){	
			if(count == 0){
				for(int k = j ; k < n ; k++){
					result.add(mat[i][k]);					
				}
			i++;
			count++;
			spiralMat( mat , m , n , i , j);								
			}
			else if (count == 1){
				for(int k = i ; k < m ; k++){
					result.add(mat[k][n-1]);					
				}
			n--;
			count++;
			spiralMat( mat , m , n , i , j);
			}
			else if (count == 2){
				for(int k = n-1 ; k >= j ; k--){
					result.add(mat[m-1][k]);					
				}
			m--;
			count++;
			spiralMat( mat , m , n , i , j);	
			}
			else if(count == 3){
				for(int k = m-1 ; k >= i ; k--){
					result.add(mat[k][j]);					
				}
			j++;
			count = count - 3;
			spiralMat( mat , m , n , i , j);	
			}
		}	
		return result;			
		}
	}
/*
1  2  3  4  5
6  7  8  9  10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
*/	