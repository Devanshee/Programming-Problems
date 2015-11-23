import java.util.*;

public class TreeLength{
	public static void main(String[] args){
		Tree t = new Tree();
		t.createNode(8);
		t.createNode(7);
		t.createNode(3);
		t.createNode(9);
		t.createNode(10);
		t.createNode(5);
		t.createNode(7);
		t.createNode(1);
	 //	int l  = t.findLength();
		t.dfs(t.root);
		t.bfs(t.root);
	} 
}

class Tree{
	static int count = 0;
	Node root;
	Queue<Node> q  = new LinkedList<Node>();
	public void createNode(int val){
		Node node = new Node(val);
		if(root == null){ root = node; }
		else{
			addToTree(node,root);
		}
		System.out.println("The node added :"+node.value);
	}
	public void addToTree(Node n, Node r){
		if(r.value > n.value){
			if(r.left == null){
				 r.left = n; 
			}else{ 
				addToTree(n,r.left); 
			}	
		}else if(r.value < n.value){	
			if(r.right == null){ r.right = n; }else { addToTree(n,r.right); }
		}
	}
	public int findLength(){
		Node n = this.root;
		return addLength(n);
	}
	public int addLength(Node n){		
		if(n != null){
			while(n.left != null){count++; n = n.left;}
			if(n.right != null){count++; addLength(n.right);}
		}
		return count;
	}
	public void dfs(Node r){
		System.out.println(r.value);
		if(r.left != null){
			dfs(r.left);
		}
		if(r.right != null){
			dfs(r.right);
		}
	}
	public void bfs(Node r){
		q.add(r);
		while(!q.isEmpty()){
			Node tmp = q.remove();
			System.out.println(tmp.value);
			if(tmp.left != null){ q.add(tmp.left); }
			if(tmp.right != null){ q.add(tmp.right); }
		}
	}

}

class Node {
	int value;
	Node left;
	Node right;
	
	Node(int val){
		value = val;
	}

	void addLeft(Node n){
		this.left = n;
	}

	void addRight(Node n){
		this.right = n;
	}
}