import java.io.*;

public class QueueStack{
	public static void main(String[] args){
		//Queue q = new Queue();
		//q.enqueue(6);
		//q.enqueue(7);
		//q.enqueue(9);
		//q.dequeue();
		Stack s = new Stack();
		s.push(12);
		s.push(17);
		s.push(88);
		Node n = s.pop();
		System.out.println("Node removed ! "+n.val);
	}
}
class Stack{
	Node top;
	void push(int v){
		Node n = new Node(v);
		if(top != null){ 			
			n.next = top;
		}
		top= n;
		System.out.println("Node added ! "+v);
	}
	Node pop() {
		if(top!= null){
			Node t = top;
			top = top.next;
			return t;
		}
		return null;
	}
}
class Queue{
	Node first;
	Node last;
	public void enqueue(int v){
		if(last == null){
			first = new Node(v);
			last = first;
			System.out.println("Head : !"+v);
		}else{
			last.next = new Node(v);
			last = last.next;
			System.out.println("Node added!"+v);
		}
	}
	public int dequeue(){
		if(first == null){System.out.println("Empty!!"); return -1;}
		else{
			System.out.println(first.val);
			int tmp = first.val;
			first = first.next;
			System.out.println("Node removed"+tmp);
			return tmp;
		}
	}
}
class Node{
	int val;
	Node next;
	public Node(int v ){
		val = v;
	}
}


