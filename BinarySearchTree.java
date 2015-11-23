public class BinarySearchTree {

	public static void main(String[] args){	

		BST tree = new BST();
		tree.insertNode(4);
		tree.insertNode(8);
		tree.insertNode(15);
		tree.insertNode(2);
		tree.insertNode(19);
		tree.insertNode(3);
	}
}

class Node{

	int val;
	Node lChild;
	Node rChild;
	Node root;		

	Node(int v){
		val = v;
		lChild = null;
		rChild = null;
	}
}

class BST{
	Node root;
	int height;
	BST(){
		
	}
	void insertNode (int val){
		if(root == null){
			root = new Node(val);
		}else{
			add(val,root);
		}
	}
	void add(int v, Node root){
		if (v == root.val){
			System.out.println("Same value as existing node");
		}else{
	
			if(v < root.val){
				if(root.lChild!=null){add(v,root.lChild);}
				else{
						root.lChild = new Node(v);
						System.out.println("Node "+v+" added! ");
					} 
			}
			else if(v > root.val){
				if(root.rChild!=null){add(v,root.rChild);}
				else{
					root.rChild = new Node(v);
					System.out.println("Node "+v+" added! ");}  
			}					
		}		
	}
	void printBST(){
		Node curr = root;
			while(curr != null){
				
			}
	}
}