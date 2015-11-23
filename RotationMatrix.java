import java.util.*;

public class RotationMatrix{
	public static void main(String[] arg){
		int[][] m = new int[4][4];
		m[0][0] = 1;
		m[0][1] = 1;
		m[1][0] = 0;
		m[1][1] = 0;
		m[0][2] = 1;
		m[0][3] = 1;
		m[1][2] = 0;
		m[1][3] = 0;
		m[2][0] = 0;
		m[2][1] = 0;
		m[2][0] = 0;
		m[2][1] = 0;
		m[3][2] = 1;
		m[3][3] = 1;
		m[3][2] = 0;
		m[3][3] = 0;
	
		for(int i = 0; i< m.length ; i++){
			for(int j = 0; j < m[0].length ; j++){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		matrixRotate(m);		
	}

	public static void matrixRotate(int[][] a){
		int[][] result = new int[a.length][a[0].length];
		for(int i = 0; i< a.length ; i++){
			for(int j = 0; j < a[0].length ; j++){
				result[j][i] = a[a.length-(i+1)][a[0].length-(j+1)];
			}
		}
		System.out.println("========================");
		for(int i = 0; i< result.length ; i++){
			for(int j = 0; j < result[0].length ; j++){
				System.out.print(result[i][j]+" ");
			}
		System.out.println();
		}
	}	
}

