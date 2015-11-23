
public class circularLinkedList {
	public static void main(String[] args){
		CList cl = new CList();
		cl.add(3);
		cl.add(7);
		cl.add(17);
		cl.add(19);
		cl.add(21);
		cl.add(24);
		cl.insert(26);
		CNode tm = cl.root;
		for(int i =0; i< 10 ; i++){
			System.out.println(tm.val);
			tm = tm.next;
		}		
	}	
}
class CList{
	CNode root;
	CList(){
	}
	void add(int vl){
		if(root == null){
			root = new CNode(vl);
			root.next = root;
		}else{
			CNode curr = root;
			while(curr.next != root){
				curr = curr.next;
			}
			curr.next = new CNode(vl);
			curr.next.next = root;
		}
	}
	void insert(int in){
		if(root.val > in){
			CNode tmp = root;
			root = new CNode(in);
			root.next = tmp;
			CNode cur = tmp;
			while(cur.next != tmp){
				cur = cur.next;
			}
			cur.next = root;
		}else if(root.val < in){
			CNode tmp = root;
			while(tmp.next.val < in && tmp.next != root){
				tmp = tmp.next;
			}
			if (tmp.next.val > in){
				CNode cur = tmp.next;
				tmp.next = new CNode(in);
				tmp.next.next = cur;
			}else{
				tmp.next = new CNode(in);
				tmp.next.next = root;
			}
		}
	}
}
class CNode{
	int val;
	CNode next;
	CNode(int v){
		val = v;
	}
}
