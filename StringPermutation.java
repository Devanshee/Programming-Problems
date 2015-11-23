import java.util.*;

public class StringPermutation{
	public static void main(String[] arg){
		String s1 = "annnnnna";
		String s2 = "aaaaanaa";
		System.out.println(checkPermute(s1,s2));
	}
	public static boolean checkPermute(String s1, String s2){
			int shifted =0;
			int result1 = 0;
			int result2 = 0;
			if(s1.length() != s2.length() || s1.length() <=0 || s2.length() <= 0 ) return false;
			if(s1.equals(s2)) return true;
			for(int i =0; i< s1.length() ; i++){
				shifted = 1 << (Integer.valueOf(s1.charAt(i)));
				result1 |= shifted;
			}
			for(int j = 0; j < s2.length() ; j++){
				shifted = 1 << (Integer.valueOf(s2.charAt(j)));
				result2 |= shifted;
			}
			if((result1 & result2) != result1){ return false;}
			return true;
	}
	
}