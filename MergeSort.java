 +public class MergeSort {
	public static void main(String[] args){
	int a[] = {1,5,4};
	SortArray sa = new SortArray();
	sa.mergeSort(a,0);
	}
}

class SortArray {
	int[] helper;
	int[] currArray;
	int length;

	void mergeSort(int[] a,int start){
		length = a.length;
		currArray = new int[a.length];
		sort(a,0,length-1);
		
	}	

	public void sort(int[] a,int start, int end){		
		if(end>start){			
			int mid = start+(end-start)/2;
			sort(a,start,mid);
			sort(a,mid+1,end);
			merge(a,start,mid,end);			
		}				
	}

	public void merge(int[] a, int 	i, int mid ,int j){
		
		 for (int p = i; p <= j; p++) {
     			 currArray[p] = a[p];
    		 }

		int k = i;
		int len = (j-i)+1;
		while(k < len){
			if(currArray[i] <= currArray[j]){ a[k] = currArray[i]; i++;}
			else if (a[i] > a[j]){ a[k] = currArray[i]; j++;}		
		k++;
		}
		if (i<=mid){
			
			a[k] = currArray[i]; 
			i++;
			k++;
		}
	}
}