import java.util.*;

public class Graph{
	public static void main(String[] a){
		GraphNode gn1 = new GraphNode(7);
		GraphNode gn2 = new GraphNode(6);
		GraphNode gn3 = new GraphNode(3);
		GraphNode gn4 = new GraphNode(9);
		GraphNode gn5 = new GraphNode(12);
		
		gn1.setNeighbour(gn2);
		gn1.setNeighbour(gn3);
		gn1.setNeighbour(gn4);
		gn2.setNeighbour(gn5);
		gn3.setNeighbour(gn4);
				
	}
}

class GraphNode{
	int value;
	ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();
	boolean visited;
	
	public GraphNode(int val){
		System.out.println("New node added : "+val);
		value = val;
	}
	
	public void setNeighbour(GraphNode n){
		System.out.println("Neighbour added : "+n.value);
		neighbours.add(n);	
	}
}
