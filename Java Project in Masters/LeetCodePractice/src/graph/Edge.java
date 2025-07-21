package graph;

public class Edge {
	private Vertex startV;
	private Vertex endV;
	private Integer weight;
	
	public Edge(Vertex startV, Vertex endV, Integer weight) {
		super();
		this.startV = startV;
		this.endV = endV;
		this.weight = weight;
	}

	public Vertex getStartV() {
		return this.startV;
	}

	public Vertex getEndV() {
		return this.endV;
	}

	public Integer getWeight() {
		return this.weight;
	}
}
