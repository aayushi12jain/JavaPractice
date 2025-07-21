package graph;

import java.util.ArrayList;

public class Vertex {
	private String data;
	private ArrayList<Edge> edges;
	
	public Vertex(String input){
		this.data = input;
		this.edges = new ArrayList<Edge>();
	}
	
	public void addEdge(Vertex endV, Integer weight) {
		this.edges.add(new Edge(this, endV, weight));
	}
	
	public void removeEdge(Vertex endV) {
		this.edges.removeIf(edge->edge.getEndV().equals(endV));
	}

	public String getData() {
		return data;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void print(boolean showWeight) {
		String message = "";
		if(this.edges.size() == 0) {
			System.out.println(this.data + "-->");
			return;
		}
		//System.out.println(this.edges.size());
		for(int i=0; i<this.edges.size(); i++) {
			if( i==0 ) {
				//System.out.println("here");
				message += this.edges.get(i).getStartV().data + "-->";
			}
			message += this.edges.get(i).getEndV().data;
			if( showWeight ) {
				message += "(" + this.edges.get(i).getWeight() + ")";
			}
			
			if( i != this.edges.size()-1 ) {
				message += ",";
			}
		}
		System.out.println(message);
		
	}

}
