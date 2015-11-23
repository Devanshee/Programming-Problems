
public class ReverseNumber {
	
		int NumRev(int n){
//			if (n/10 == 0) return n;
			int rev = 0;
			while(n!=0){			
			rev = (rev*10)+n%10;
			n=n/10;
			}
			return rev;
		}
		public static void main(String arg[]){
			ReverseNumber nr = new ReverseNumber();
			System.out.println("result : "+nr.NumRev(1234));			
		}
}
