import java.util.*;

public class Permutation{
	static int max = 0;
	static int count = 0,c=0;
	public static void main(String[] args){
		HashMap<Integer,ArrayList<String>> hm = new HashMap<Integer,ArrayList<String>>();
		ArrayList<String> ar1;
		ArrayList<String> ar2;
		ArrayList<String> ar3;
		ArrayList<String> ar4;
		StringBuilder sb = new StringBuilder();
		ar1 = new ArrayList<String>();
		ar2 = new ArrayList<String>();
		ar3 = new ArrayList<String>();
		ar4 = new ArrayList<String>();
		ar1.add("www");	ar1.add("xyz"); 
		ar1.add("abc"); 
		ar2.add("google"); ar2.add("amazon"); 
		ar2.add("facebook"); 
		ar3.add("com"); ar3.add("org"); 
		ar3.add("in");		
		ar4.add("C");	ar4.add("B"); 
		ar4.add("A");
		hm.put(0, ar1);
		hm.put(1, ar2);
		hm.put(2, ar3);
		hm.put(3, ar4);
		hm.put(4, ar1);
		hm.put(5, ar2);
		hm.put(6, ar3);
		hm.put(7, ar4);
		max = hm.size();
		String[] arResult = new String[max];
		createCombinations(hm,0,arResult);	
		
	}
	
	static void createCombinations(HashMap<Integer,ArrayList<String>> input, int index, String[] arResult){
		ArrayList<String> ar = input.get(index);
		for(int j =0 ; j< ar.size() ; j++){
			arResult[index] = ar.get(j);
			if(input.get(index+1)!= null){
				createCombinations(input, index+1, arResult);
			}else{
				for(int k = 0; k < arResult.length ; k++){		
					System.out.print(arResult[k]+".");
				}
				//System.out.println();
				
			}			
		}
	}
}