import java.util.*;

public class LinkedListImplementation{
	public static void main(String[] arg){
	
		LinkedList ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.printNodes();
		ll.deleteNode(3);
		ll.printNodes();
	}


}
class Node{
	int value;
	Node next;
	Node(int v){
		value = v;
		System.out.println("Value added"+value);
	}
}
class LinkedList{
	Node head;
	void add(int val){
		if(head == null){ head = new Node(val); return;}

		Node node = head;
		while(node.next != null){
			node = node.next;
		}
		node.next = new Node(val);
	}
	public void printNodes(){
		Node n = head;
		System.out.println(n.value);
		while(n.next != null){
			n = n.next;
			System.out.println(n.value);
		}
	}
	public void deleteNode(int v){
		Node node = head;
		Node prev= node;
		while(node != null){		
			if(node.value == v){ 
				System.out.println("Value found!"+v);
				if(node.next != null){prev.next = node.next;}
				else prev.next = null;
				return;
			}
			prev = node;
			node = node.next;
		}
	}
}

