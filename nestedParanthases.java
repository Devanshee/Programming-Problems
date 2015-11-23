import java.util.Stack;


public class nestedParanthases {
	public static void main(String[] str){
		String s = "(({}[])}{()}{)";
		System.out.println(isBalanced(s));
	}
	public static boolean isBalanced(String in){
		if(in.length()%2 != 0) return false;
		Stack<Character> s = new Stack<Character>();
		for(int i =0; i< in.length() ; i++){
			if(s.isEmpty()){
				s.add(in.charAt(i));
			}else{
				if((s.peek().equals('(') && in.charAt(i) == ')') || (s.peek().equals('[') && in.charAt(i) == ']') || (s.peek().equals('{') && in.charAt(i) == '}')){
					s.pop();
				}else{
					s.push(in.charAt(i));
				}
			}
		}
		if(s.isEmpty())return true;
		return false;
	}
}
