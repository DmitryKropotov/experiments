package graphs;

public interface Node {
    void addToNodesToThis(Node... nodesToThis);
    void addToNodesFromThis(Node... nodesToThis);
    int getNumber();
    Node[] getNodesToThis();
    Node[] getNodesFromThis();
    int getValue(int N, int nodeNumberInSequence);
}
