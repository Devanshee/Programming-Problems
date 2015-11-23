import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class IndexPermutation {
	static int c =0;
	public static void main(String[] args){
		List<Integer> al = new LinkedList<Integer>();
		int num = 6;
		for(int i = 0 ;i < num ; i++){
			al.add(i);
		}
		nthPerm(num,123,al);
		System.out.print(c+" complexity n: "+num);
	}
	static void nthPerm(int num,int ind,List<Integer> al){
		c++;
		int perm =1;
		int res = 0,cnt = 0;
		if (num==1){
				for(int i : al){
				System.out.print(i); 
			}
		}
		else{
			for(int i = num-1; i>0 ; i--){
				perm = perm*i;
			}			
			while(res < ind){
			
				res = res+perm;
				cnt++;
			}
			System.out.print(al.get(cnt-1)+" ");
			al.remove(cnt-1);
			nthPerm(num-1,ind-(res-perm),al);
		}
	
	}
}
