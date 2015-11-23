import java.util.*;

public class MaxRepetition{
	public static void main(String args[]){
		int[] inArray = {1,1,2,2,4,4,8,8,8,8,7,7,7};
		findRepetition(inArray);
	}
	public static void findRepetition(int[] input){
		int count = 1, tmp = input[0];
		int max = 0,maxElement = 0;
		for(int i = 1 ; i<input.length ; i++){
		
			if(input[i] != tmp){
				count = 1;
				tmp =input[i];
			}else{
				count++;
			} 
			if(max<count){
					max = count;
					maxElement = input[i-1];
				}
		} 
		System.out.println("The max element is : "+maxElement);
	}
}

