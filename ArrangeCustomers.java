import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ArrangeCustomers{

	public static BlockingQueue<Integer> numofCustomers = new LinkedBlockingQueue<Integer>();
	public static void main(String[] args){

		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of Attendants:");
		int threadCount = s.nextInt();
		System.out.println("Enter number of groups coming to the Restaurant:");
		int groupCount = s.nextInt();
		System.out.println("Enter number of 2 seated Tables:");
		int t1 = s.nextInt();
		System.out.println("Enter number of 4 seated Tables:");
		int t2 = s.nextInt();
		System.out.println("Enter number of 8 seated Tables:");
		int t3 = s.nextInt();

		Random rCust = new Random();

		for(int i =0; i<groupCount ; i++){
			try{
				int added = 1+rCust.nextInt(20);
				numofCustomers.put(added);
				System.out.println(added);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		initialization("T1",t1);  
		initialization("T2",t2);
		initialization("T3",t3);
		SeatingArr.numCust = numofCustomers;
		SeatingArr.available = new HashMap<String, Integer>(SeatingArr.tables);
		for(int j=0; j < threadCount ; j++){
			new Thread(new SeatingArr(j+1)).start();
		}
	}
	static void initialization(String table, int count){
		// diff group sizes
		if(table.equals("T1")){
			SeatingArr.tables.put("T1", count);
			SeatingArr.total += 2*count;
		}	
		if(table.equals("T2")){
			SeatingArr.tables.put("T2", count);
			SeatingArr.total += 4*count;
		}
		if(table.equals("T3")){	
			SeatingArr.tables.put("T3", count);
			SeatingArr.total += 8*count;
		}
	}
}
class SeatingArr implements Runnable{

	protected Thread runningThread = null;	
	public static BlockingQueue<Integer> numCust = new LinkedBlockingQueue<Integer>();
	public static Map<String,Integer> tables = new HashMap<String,Integer>();
	List<String> used=new ArrayList<String>();
	int id;
	Queue<Integer> inputQueue = new LinkedList<Integer>();
	static int total;
	int num, emp, left, t1av, t2av;
	public static HashMap<String,Integer> available;
	SeatingArr(int i){
		id = i;
	}
	void seat(int n){

		if(n<=0){
			System.out.println("check input"); 
		}else if(n<=2){
			updateAvailable("T1","sub");
			used.add("T1");
		}else if(n<=4){
			updateAvailable("T2","sub");
			used.add("T2");
		}else if(n<=8){
			updateAvailable("T3","sub");
			used.add("T3");
		}else if(n<=total){
			left = n;
			//Checks availability of tables
			while(((t1av = getAvailable("T1"))*2 + (t2av = getAvailable("T2"))*4) < n){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while(left>0){
				if((left > 2 || getAvailable("T1") == 0) && getAvailable("T2") != 0){
					left -= 4;
					updateAvailable("T2","sub");	
					used.add("T2");
				}
				else if(getAvailable("T1") != 0){
					left -= 2;
					updateAvailable("T1","sub");					
					used.add("T1");
				}
			}
		}
		System.out.println("Using seats "+used+" by attendant:"+id+" | serving "+num+" persons");
	}
	void free(){
		for(String s : used){
			updateAvailable(s,"add");
		}
		System.out.println("After freeing the seats "+available+" by attendant: "+id+" | served "+num+" persons");
		used = new ArrayList<String>();
	}
	public void run(){
		while(true){
			if(!numCust.isEmpty()){
				num = numCust.poll();
				System.out.println("id: "+id+" serving "+num+" person group form Queue");
				Random r = new Random();
				emp = (int)(30+r.nextInt(15));
				seat(num);
				try {
					Thread.sleep(emp*1000);		//For testing purpose at a small scale time is measured in Seconds instead of minute(waits for 30 to 45 secs)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
				free();
			}else{
				try {
					Thread.sleep(1000);		
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}
	}
	public static synchronized void updateAvailable(String t,String action){
		if(action.equals("add")){
			available.put(t, available.get(t)+1);
		}
		if(action.equals("sub")){
			while(available.get(t) <= 0){
				try {
					Thread.sleep(5000);		
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
			}
			available.put(t, available.get(t)-1);
		}		
	}
	public static synchronized int getAvailable(String t){
		return available.get(t);
	}
}