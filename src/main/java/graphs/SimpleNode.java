package graphs;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SimpleNode implements Node {
    private int number;
    private List<Node> nodesToThis;
    private List<Node> nodesFromThis;

    public SimpleNode(int number, List<Node> nodesToThis, List<Node> nodesFromThis) {
        this.number = number;
        this.nodesToThis = nodesToThis;
        this.nodesFromThis = nodesFromThis;
    }

    @Override
    public void addToNodesToThis(Node... nodesToThis) {
        this.nodesToThis.addAll(Arrays.asList(nodesToThis));
    }

    @Override
    public void addToNodesFromThis(Node... nodesFromThis) {
        this.nodesFromThis.addAll(Arrays.asList(nodesFromThis));
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public Node[] getNodesToThis() {
        return nodesToThis.toArray(new Node[0]);
    }

    @Override
    public Node[] getNodesFromThis() {
        return nodesFromThis.toArray(new Node[0]);
    }

    @Override
    public int getValue(int N, int nodeNumberInSequence) {
        return N^(nodeNumberInSequence-1)*getNumber();
    }
}
