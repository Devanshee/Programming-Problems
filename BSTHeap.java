import java.util.*;

public class BSTHeap{
	static Node root =null;
	public static void main(String[] args){
		Node n[] = new Node[8];
		n[6] = new Node(5,16);
		n[1] = new Node(3,15);
		n[5] = new Node(7,14);
		n[3] = new Node(2,13);
		n[7] = new Node(4,12);
		n[0] = new Node(6,11);
		n[2] = new Node(8,10);
		n[4] = new Node(1,9);
		createTree(n);
		preOrder(root);
	}
	public static void inOrder(Node root){
		if(root == null) return;
		inOrder(root.left);
		System.out.println(root.iKey);
		inOrder(root.right);
	}	
	public static void preOrder(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		for(!q.empty()){
		n = q.remove();
		System.out.println(n.iKey);
		if(n.left != null){q.add(n.left);}
		if(n.right != null){q.add(n.right);}
	}
}
	public static void createTree(Node[] nodes){
				
		for(int k = 0; k < nodes.length ; k++){
			if(root == null){ root = nodes[k]; }
			root = addNodes(nodes[k],root);
			//System.out.println("Node: "+nodes[k].iKey+" , "+nodes[k].jKey+" added!");
			System.out.println("=========================");
		}				
	}
	public static Node addNodes(Node n,Node root){

		if(root.jKey > n.jKey){
			if(root.iKey > n.iKey){
				if(root.left == null){
					root.left = n;
					System.out.println("Node: "+n.iKey+" , "+n.jKey+" added as a left child of !"+root.iKey+"-"+root.jKey);
				}else{
					addNodes(n,root.left);
				}
			}else{
				if(root.right == null){
					root.right = n;
					System.out.println("Node: "+n.iKey+" , "+n.jKey+" added as a right child of !"+root.iKey+"-"+root.jKey);
				}else{
					addNodes(n,root.right);
				}
			}
		}else{
			if(root.iKey > n.iKey){
				n.right = root;				
				System.out.println("Node: "+n.iKey+" , "+n.jKey+" added as a Root instead of !"+root.iKey+"-"+root.jKey);
				root = n;
			}
			if(root.iKey < n.iKey){
				n.left = root;
				System.out.println("Node: "+n.iKey+" , "+n.jKey+" added as a Root instead of !"+root.iKey+"-"+root.jKey);
				root = n;
			}
		}
		return root;
	}
}

class Node{
	int iKey;
	int jKey;
	Node left;
	Node right;

	Node(int i , int j){
		iKey = i;
		jKey = j;
	}
	public String toString(){
		
		System.out.println(""+iKey);
		return ""+iKey;
	}
}