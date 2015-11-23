import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedListDemo{
	public static void main(String[] args){

	  Stack<String> s = new Stack<String>();
      LinkedList<String> ll = new LinkedList<String>();
	  Queue<String> q = new LinkedList<String>();
	  q.add("Hi");
	  q.add("Hello");
	  q.add("How");
	  q.add("are");
      // add elements to the linked list
      s.push("F");
      s.push("B");
      s.add("D");
	  System.out.println("Original contents of Queue ::::: " + s);
	  s.pop();
	  System.out.println("Original contents of Queue ::::: " + s);
      ll.add("E");
      ll.add("C");
      ll.addLast("Z");
      ll.addFirst("A");
      ll.add(1, "A2");
      System.out.println("Original contents of Queue ::::::::::::::: " + q.remove());
	  q.add("huuuus");
	   System.out.println("Original contents of Queue ::::::::::::::: " + q);
      // remove elements from the linked list
      ll.remove("F");
      ll.remove(2);
      //System.out.println("Contents of ll after deletion: "
       //+ ll);
      
      // remove first and last elements
      ll.removeFirst();
      ll.removeLast();
      //System.out.println("ll after deleting first and last: "
       //+ ll);

      // get and set a value
      //Object val = ll.get(2);
      //ll.set(2, (String) val + " Changed");
      //System.out.println("ll after change: " + ll);
	}
}