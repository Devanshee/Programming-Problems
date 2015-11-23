	
	


	class Node{

		int val;
		Node lChild;
		Node rChild;
		Node root;		

		public Node(int v){
			this.val = v;
		}

		public void insertNode (int val){
			
			if (val == this.val){
				System.out.println("Same value as this node");
			}
			else{
					if(val < this.val){
						if(lChild!=null){lChild.insertNode(val);}
						else{lChild = new Node(val);} 
					}
					else if(val > this.val){
						if(rChild!=null){rChild.insertNode(val);}
						else{lChild = new Node(val);}  
					}					
			}
			
			System.out.println("Node added!"+val);
		}
		public void preOrder(){
			System.out.println("Node : "+this.val);
			if(this.lChild != null) {this.lChild.preOrder();}
			if(this.rChild != null) {this.rChild.preOrder();}
		}
	}
	
	public class Tree{

		public static void main(String[] args){
			
			Node root = new Node(10);
			root.insertNode(4);
			root.insertNode(8);
			root.insertNode(15);
			root.insertNode(12);
			root.insertNode(19);
			
			root.preOrder();
		}
		
	}