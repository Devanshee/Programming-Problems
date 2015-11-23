import java.util.*;

public class SplitArray{
	public static void main(String args[]){
		int[] inArray = {6,3,7,8,8};
		System.out.println(findIndex(inArray));
	}
	public static int findIndex(int[] input){
		int startSum =0,i=0,j=(input.length)-1;
		int endSum =0;
		while(i < input.length && j >=0){
			if(i==j || (j-i)==1){ break;}
				startSum += input[i];				
				endSum += input[j];
				if(startSum > endSum){
					System.out.println("j decreased : "+startSum);
					j--; 
					continue;
				}else if (startSum < endSum){
					//System.out.println("i increased : "+endSum);
					i++; 
					continue;
				}
				i++;System.out.println("i increased : ");
				j--;System.out.println("j decreased : ");
		}
		return j;
	}
}
