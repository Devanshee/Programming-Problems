import java.util.*;

public class Overlap{

	public static void main(String[] args){
//	int[][] input = {{-1,1},{4,9},{7,11},{14}};
	ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();	
	ArrayList<Integer> temp1 = new ArrayList<Integer>();
	ArrayList<Integer> temp2 = new ArrayList<Integer>();
	ArrayList<Integer> temp3 = new ArrayList<Integer>();
	ArrayList<Integer> temp4 = new ArrayList<Integer>();
	temp1.add(0,-1);
	temp1.add(1,1);
	temp2.add(0,4);
	temp2.add(1,9);
	temp3.add(0,7);
	temp3.add(1,11);
	temp4.add(0,14);
//	temp4.add(1,15);
	input.add(temp1);
	input.add(temp2);
	input.add(temp3);
	input.add(temp4);
	findInterval(input);
	}
	
	public static void findInterval(ArrayList<ArrayList<Integer>> input){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		boolean flag = false;
		int cnt = 1;
		tmp = input.get(0);
		result.add(tmp);
		for(int i =1; i<input.size() ; i++){
			
			ArrayList<Integer> res = new ArrayList<Integer>();
			
			curr = input.get(i);
	//		System.out.println(curr+"   "+tmp);
			
			if(tmp.size() != 0){
				if(tmp.get(0) <= curr.get(0)){ 
					if((curr.get(0))-(tmp.get(tmp.size()-1))>1){
					// input.get(i).get(input.get(i).size()-1)
				//			System.out.println(tmp+"   "+i);
							res = tmp;							
							tmp = curr;
							flag = true;
							if(result.get(cnt-1)!= res){result.add(cnt,res); cnt++;}
					}else{
						res.add(0,tmp.get(0));
						//if(input.get(i).get(0) != tmp.get(tmp.size()-1)){tmp.add(1,input.get(i).get(input.get(i).size()-1));}
						if(tmp.get(tmp.size()-1) < curr.get(curr.size()-1)){res.add(1,curr.get(curr.size()-1));}
						else{res.add(1,tmp.get(tmp.size()-1));}
					//	System.out.println(res+"    "+i);
						tmp = res;
						flag=false;
					}
				}else{System.out.println("Not in sorted order");}
			}else{continue;}
		
		System.out.println(result);		
	}
	if(flag){System.out.println(tmp);}
}
}