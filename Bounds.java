import java.io.*;
import java.util.ArrayList;

public class Bounds {

	public static void main(String args[]){
		
		int d = 1;
		int k = 5;
	
	boolean[] used = new boolean [3];
	int[] servers = {1,3,5,4};
	int[] tasks ={4,2,6};
		System.out.println(canArrangeRecursive(servers, tasks, used));
	}
	
	public static String findBound(int ch, int occurances) { 
		int low = 1;
		int high = 0;
		int count = 0;
		int num,i = 0;
		while(count <= occurances){
			num = i;
			while(num != 0){
				if(num%10 == ch){
					count++;
					if(count == 1){low = i;}
				}
				num /=10;
			}
			i++;
		}
		high = i-2;
		return "("+low+" , "+high+")";
	}
	
	public static boolean canArrange(int[] servers, int[] tasks) {
        boolean[] used = new boolean[tasks.length];
        return canArrangeRecursive(servers, tasks, used);
    }

    public static boolean canArrangeRecursive(int[] servers, int[] tasks, boolean[] used) {
        boolean allUsed = true;
        for (boolean b : used) {
            allUsed &=b;
        }
        if (allUsed){
            return true;
        }
        for (int i = 0; i < tasks.length; i++) {
            if (!used[i]) {
                used[i] = true;
                for (int j = 0; j < servers.length; j++) {
                    if (servers[j] >= tasks[i]) {
                        servers[j] = servers[j] - tasks[i];
                        if(canArrangeRecursive(servers, tasks, used)){
                            return true;
                        }
                        servers[j] = servers[j] + tasks[i];
                    }
                }
                used[i] = false;
            }
        }
        return false;
	}
}