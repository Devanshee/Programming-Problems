// The program to create a BST using input node values

import java.util.Stack;

class NodeT{
	int data;
	NodeT right;
	NodeT left;

	NodeT (int n){
		data = n;
		right = null;
		left = null;
	}
}

public class NonREcursiveT{
	
	public static void main(String[] args){
		NodeT root = new NodeT(10);
		NodeT n1 = new NodeT(14);
		NodeT n2 = new NodeT(2);
		NodeT n3 = new NodeT(6);	
		NodeT n4 = new NodeT(1);
		addBST(root,n1);
		addBST(root,n2);
		addBST(root,n3);
		addBST(root,n4);
	
		preOrder(root);
	}

//This method compares the value of new node with existing node values

	public static void addBST(NodeT r, NodeT n){
		if(r.data == n.data){
			System.out.println("The value is same as root");
		}
		else{
			if(n.data<r.data){
				if(r.left != null){ addBST(r.left,n); }
				else {r.left = n;}
			}
			else if (n.data > r.data){
				if(r.right != null){addBST(r.right,n);}
				else{r.right = n;}
			}
		}
	}
	public static void inOrder(NodeT r){
		
		Stack<NodeT> s = new Stack<NodeT>();
		NodeT p = r;
		
		while(!s.isEmpty() || p != null){
			if(p != null){
				s.push(p);
				p = p.left;
				
			}
			else{
				p = (NodeT)s.pop();
				System.out.println(p.data);
				p = p.right;
			}
		}		
	}
	public static void preOrder(NodeT r){
		
		Stack<NodeT> s = new Stack<NodeT>();
		NodeT p;
		s.push(r);
		while(!s.isEmpty()){
			p = s.pop();
			System.out.println(""+p.data);
			if(p.right != null){s.push(p.right);}
			if(p.left != null){s.push(p.left);}
		}		
	}
}