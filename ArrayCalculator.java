
import java.util.*;
import java.lang.Integer;

public class ArrayCalculator{
	public static void main(String[] args){
		String in = "+ 2 3";
		System.out.println("Result:"+calculateResult(in));
	}
	public static String calculateResult(String in){
		Stack<String> s =new Stack<String>();
		String[] c = in.split(" ");
		for(int i = c.length-1 ; i >= 0 ; i--){
			if(c[i].equals("(")||c[i].equals(")")){
				continue;
			}
			if(c[i].equals("*")||c[i].equals("/")||c[i].equals("+")||c[i].equals("-")){
				s.push(produceResult(s,c[i]));
			}
			else{
				s.push(c[i]);
			}
		}
		return s.pop();
	}
	public static String produceResult(Stack s, String c){
		int operand1 = Integer.parseInt((String)s.pop());
		int operand2 = Integer.parseInt((String)s.pop());
		float result = 0;
	
		switch(c){
					case "+":
						result = operand1 + operand1;
						break;
					case "-":
						result = operand1 - operand2;
						break;
					case "*":
						result = operand1 * operand2;
						break;
					case "/":
						if(operand2 == 0){
							result = operand1 / operand2;
						}else{
							System.out.println("Can not divide by Zero!!!");
						}
					default :
						System.out.println("Not useful");
						break;
				}
		System.out.println(result);
		return Float.toString(result);
	}
}