import java.io.*;
import java.util.*;

public class SalesPath {
	
	static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }

        Node(int cost, Node[] children) {
            this.cost = cost;
            this.children = children;
            parent = null;
        }
    }

    static int getCheapestCost(Node rootNode) {
        int cost = rootNode.cost;
        if (rootNode.children != null) {
            int minChildCost = Integer.MAX_VALUE;
            for (Node child : rootNode.children) {
                int childCost = getCheapestCost(child);
                if (childCost < minChildCost) {
                    minChildCost = childCost;
                }
            }
            if (minChildCost != Integer.MAX_VALUE) {
                cost += minChildCost;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Node root = new Node(0,
                new Node[]{
                        new Node(5, new Node[]{new Node(4)}),
                        new Node(3,
                                new Node[]{
                                        new Node(2, new Node[]{new Node(1, new Node[]{new Node(1)})}),
                                        new Node(0, new Node[]{new Node(10)})
                                }),
                        new Node(6, new Node[]{
                                new Node(1),
                                new Node(5)
                        })
                });
        System.out.println(SalesPath.getCheapestCost(root));
    }
}