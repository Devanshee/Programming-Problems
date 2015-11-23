
public class FindDuplicate {
		int find(int[] a){
			int len = a.length;
			if (len == 1) return 0;
			int sum = 0;
			int total = (len* (len -1))/2;
			for(int i =0; i<len ; i++){
			sum = sum + a[i]; 
			}
			
			return sum-total;
		}
		public static void main(String a[]){
			int[] arr = {1,2,7,6,9,9,4,8,3,5};
			 FindDuplicate fd = new  FindDuplicate();
			System.out.println("duplicate num is : " +fd.find(arr));
		}
}
