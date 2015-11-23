import java.util.*;

public class findSimilarity{
	static int zero = 0;
	static int dupli = 0;
	static int temp = 1;
	public static void main(String[] args){
		int number[] = {1,4,5,1,4,3,7,9,3,4,6,5,1,3};
		getDuplicates(number);
	}
	
	static void getDuplicates(int[] num){
		for(int i = 0; i < num.length ; i++){
			int shiftedBit = 1 << num[i];
			temp = zero;
			zero  |= shiftedBit;
			
			//System.out.println("zero before "+zero);
			if(zero == temp){
				//System.out.println("Found even number of times "+num[i]);
				temp = dupli;
				dupli |= shiftedBit;	
				if(temp == dupli){
					System.out.println("Three times "+num[i]);
				}
			}
				
			
		}
	}
}





