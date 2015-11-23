import java.util.*;

public class Permutation{
	public static void main(String[] args){
		int[] in = {2,5,8};
		boolean[] visited = new boolean[in.length];
		int len = 0;
		StringBuilder sb = new StringBuilder();
		permute(in,visited,len,sb);
	}
	
	public static void permute(int[] in , boolean[] visited, int l, StringBuilder sb){
		
		if(sb.length() == l){System.out.println(sb.toString());}
		
		for(int i =0; i < in.length ; i++){
			if(visited[i] == true) continue;
			visited[i] = true;
			permute(in , visited , l, sb);
			visited[i] = false;
			sb.setLength(sb.length - 1);			
		}
	}
}
