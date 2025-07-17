package graph;

import java.util.ArrayList;

public class Graph {

	private ArrayList<Vertex> vertices;
	private boolean isWeighted;
	private boolean isDirected;
	
	public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
		this.vertices = new ArrayList<Vertex>();
		this.isWeighted = inputIsWeighted;
		this.isDirected = inputIsDirected;
	}
	
	public Vertex addVertex(String data) {
		Vertex v = new Vertex(data);
		vertices.add(v);
		return v;
	}
	
	public void addEdge(Vertex startV, Vertex endV, Integer weight) {
		if(!isWeighted) {
			weight = null;
		}
		startV.addEdge(endV, weight);
		if(!isDirected) {
			endV.addEdge(startV, weight);
		}
	}
	
	public void removeEdge(Vertex v, Vertex removeV) {
		v.removeEdge(removeV);
		if(!isDirected) {
			removeV.removeEdge(v);
		}
	}
	
	public void removeVertex(Vertex v){
		this.vertices.remove(v);
	}
	
	public Vertex getVertexByValue(String val) {
		for(Vertex v:this.vertices) {
			if(v.getData().equals(val)) {
				return v;
			}
		}
		return null;
	}
	
	public ArrayList<Vertex> getVertices() {
		return this.vertices;
	}

	public boolean isWeighted() {
		return this.isWeighted;
	}

	public boolean isDirected() {
		return this.isDirected;
	}

	public void print() {
		for(Vertex v:this.vertices) {
			v.print(isWeighted);
		}
	}
	
}
