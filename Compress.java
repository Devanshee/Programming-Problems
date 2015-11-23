import java.util.* ;

public class Compress{
	public static void main(String[] args){
		String s  = "aabbccc";
		System.out.println(compressString(s));
	}
	public static String compressString(String s){
		char[] ch = new char[s.length()];
		ch = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int r = 0, sd = 0, count=1;
		char temp = '\0';
		for(int i =0; i< ch.length ; i++){
			sd = 1 << (Integer.valueOf(ch[i]) - 97);
			if((r&sd) != 0){
				count++;
			}else {
				if(i != 0){
					sb.append(String.valueOf(temp)+""+Integer.toString(count));
					count = 1;
				}
				r |= sd;
			}
		temp = ch[i];
		}
		sb.append(temp+""+Integer.toString(count));
		return sb.toString();
	}
}

