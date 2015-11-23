import java.util.*;

public class GeneratePermutations{
	public static void main(String[] a){
	
		int[] in = {2,5,8,1};
		boolean[] visited = new boolean[in.length];
		
		int len = 3;
		StringBuilder sb = new StringBuilder();
		permute(in,visited,len,sb);
	}
	
	public static void permute(int[] in , boolean[] visited, int l, StringBuilder sb){
		
		if(sb.length() == 4){System.out.println(sb.toString());}
		
		for(int i =0; i < in.length ; i++){
			if(visited[i] == true) continue;
			visited[i] = true;
			sb.append(in[i]);
			//System.out.println(sb.toString());
			permute(in , visited , l, sb);
			visited[i] = false;
			if(sb.length()>0) { sb.setLength(sb.length() - 1);}			
		}
	}
}
