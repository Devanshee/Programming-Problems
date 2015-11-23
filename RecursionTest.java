
public class RecursionTest {
	static int c =0;
	public static void main(String[] args){
		int num =5;
		nthPerm(num);
		System.out.print(c+" complexity n: "+num);
	}
	static void nthPerm(int n){
		c++;
		if(n>0){
			nthPerm(n-1);
			nthPerm(n-1);
			nthPerm(n-1);
			nthPerm(n-1);
		}
	}
}



