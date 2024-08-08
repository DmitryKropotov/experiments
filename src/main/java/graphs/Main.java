package graphs;

import org.apache.commons.collections.set.ListOrderedSet;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Node node1 = new SimpleNode(1, new ArrayList<>(), new ArrayList<>());
        Node node2 = new SimpleNode(2, new ArrayList<>(), new ArrayList<>());
        Node node3 = new SimpleNode(3, new ArrayList<>(), new ArrayList<>());
        Node node4 = new SimpleNode(4, new ArrayList<>(), new ArrayList<>());
        Node node5 = new SimpleNode(5, new ArrayList<>(), new ArrayList<>());
        Node node6 = new SimpleNode(6, new ArrayList<>(), new ArrayList<>());

        node1.addToNodesToThis(node2);
        node1.addToNodesFromThis(node4, node6);
        node2.addToNodesFromThis(node1, node3, node4, node5);
        node3.addToNodesToThis(node2);
        node3.addToNodesFromThis(node6);
        node4.addToNodesToThis(node2, node5);
        node4.addToNodesFromThis(node6);
        node3.addToNodesToThis(node2);
        node3.addToNodesFromThis(node6);
        node4.addToNodesToThis(node1, node2, node5);
        node4.addToNodesFromThis(node6);
        node5.addToNodesToThis(node2);
        node5.addToNodesFromThis(node4, node6);
        node6.addToNodesToThis(node1, node3, node4, node5);

        int[] result = topSortWthMaxValue(new Graph(new Node[]{node1, node2, node3, node4, node5, node6}));
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] topSortWthMaxValue(Graph graph) {
        Node[] nodes = graph.getNodes();
        List<Node> nodesToBegin = new ArrayList();
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i].getNodesToThis().length == 0) {
                nodesToBegin.add(nodes[i]);
            }
        }
        Map<int[], Integer> possibleResults = new HashMap<>();
        for (Node node : nodesToBegin) {
            Set<Node> nodesToVisit = nodesToBegin.stream().filter(node1 -> node1.equals(node)).collect(Collectors.toSet());
            List<Integer> visitedNodes = new ArrayList<>();
            visitedNodes.add(node.getNumber());
            int sum = node.getValue(graph.getNumberOfNodes(), 1);
            possibleResults.putAll(dfs(graph, possibleResults, visitedNodes, nodesToVisit, node, sum, 2));
        }
        Map<int[], Integer> finalPossibleResults = possibleResults;
        Optional<int[]> result = possibleResults.keySet().stream().max(Comparator.comparingInt(finalPossibleResults::get));
        return result.orElseGet(() -> new int[0]);
    }

    private static Map<int[], Integer> dfs(Graph graph, Map<int[], Integer> possibleResults, List<Integer> visitedNodes,
                                            Set<Node> nodesToVisit, Node visitingNode, int sum, int nodeNumberInSequence) {
//        System.out.println("sum is " + sum);
//        for (Integer visitedNode : visitedNodes) {
//            System.out.println(visitedNode);
//        }
        nodesToVisit.remove(visitingNode);
        Set<Node> copyOfNodesToVisit = new HashSet<>();
        copyOfNodesToVisit.addAll(nodesToVisit);
        for (Node nodeFrom : visitingNode.getNodesFromThis()) {
            if(!visitedNodes.contains(nodeFrom.getNumber())) {
                copyOfNodesToVisit.add(nodeFrom);
            }
        }
        List<Integer> copyOfVisitedNotes = new ArrayList<>(visitedNodes);
        if(copyOfNodesToVisit.size()>1) {
            for (Node nodeToVisit : copyOfNodesToVisit) {
                Set<Node> nodesToVisitRecursively = copyOfNodesToVisit.stream().filter(node1 -> node1.equals(nodeToVisit)).collect(Collectors.toSet());
                copyOfVisitedNotes.add(nodeToVisit.getNumber());
                sum+=nodeToVisit.getValue(graph.getNumberOfNodes(), nodeNumberInSequence);
                possibleResults.putAll(dfs(graph, possibleResults, copyOfVisitedNotes, nodesToVisitRecursively, nodeToVisit, sum, nodeNumberInSequence+1));
            }
        } else if(copyOfNodesToVisit.size()==1) {
            Node lastNode = copyOfNodesToVisit.stream().findFirst().get();
            copyOfVisitedNotes.add(lastNode.getNumber());
            possibleResults.put(copyOfVisitedNotes.stream().mapToInt(x->x).toArray(), sum+lastNode.getValue(graph.getNumberOfNodes(), nodeNumberInSequence));
        }
        return possibleResults;
    }
}
