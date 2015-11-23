// input array
import java.util.*;

public class MaxSubArray{
		
	public static void main(String[] args){
		int[] in = {4,-9,3,-2,4,-12};
		//System.out.println(findSubArray(in));
	}
	public static int[] findSubArray(int[] input){
		int len = input.length;
		int[] result;
		int maxSum = 0;
		int sum = 0;	
		int maxIndex= 0;
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0; i<len; i++){
			sum += input[i];
			if(sum > maxSum){
				maxSum = sum;
				maxIndex = i;
			}
			if(sum < 0){
				sum = 0;
			}
		}
		result = new int[maxSum];
		for(int j = maxIndex; maxSum == 0; j--){
			maxSum -= input[j];
			s.push(input[j]);	
		}
		for(int k=0; k < s.size() ; k++){
			result[k] = s.pop();	
			System.out.println("HI : "+result[k]);
		}
		System.out.println("HI : "+result);
		return result;
	}
}