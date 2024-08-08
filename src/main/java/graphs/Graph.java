package graphs;

public class Graph {
     private Node[] nodes;

    public Graph(Node[] nodes) {
        this.nodes = nodes;
    }

    public int getNumberOfNodes() {
        return nodes.length;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public Node getNode(int n) {
        return nodes[n];
    }
}
