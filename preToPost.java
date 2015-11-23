import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class preToPost {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		String ll = s.nextLine();
		String[] ar = ll.split("\\s+");
		Queue<Integer> input = new LinkedList<Integer>();
		for(int i = 0 ; i < ar.length ; i++){
			input.add(Integer.parseInt(ar[i]));
		}
		convert(input);
	}
	public static void convert(Queue<Integer>  in){
		printNode(in,-1);
	}
	public static void printNode(Queue<Integer> list ,int parent){
		int root;
		if(!list.isEmpty()){
			root = list.poll();
			//Root Node
				int j=1;
				while(!list.isEmpty() && list.peek() < root){
					printNode(list,root);
				}
				while(!list.isEmpty() && ((list.peek() < parent) || parent == -1)){
					printNode(list,parent);
				}
			System.out.println(root);
		}
	}
}
