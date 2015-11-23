import java.util.*;

public class Rotation {
	public static void main(String[] arg){
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(checkRotation(s1,s2));
	}
	public static boolean checkRotation(String s1, String s2){
			String s3 = s1+""+s2;
			if(isSubString(s1,s3)){return true;}
			return false;
	}
	
}