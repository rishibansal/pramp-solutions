import java.io.*;
import java.util.*;

public class LargestSmallerBSTKey {
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		/*
			20
			|- 9
			   |- 5
			   |- 12
			      |- 11
			      |- 14
			|- 25
			inorder traversal gives: 5 -> 9 -> 11 -> 12 -> 14 -> 20 -> 25
		*/
			
		tree.insert(20);
	    tree.insert(9);
	    tree.insert(25);
	    tree.insert(5);
	    tree.insert(12);
	    tree.insert(11);
	    tree.insert(14);
	    
	    printResult(20, tree.findLargestSmallerKey(20)); // 14
	 	printResult(9, tree.findLargestSmallerKey(9)); // 5
		printResult(25, tree.findLargestSmallerKey(25)); // 20
		printResult(5, tree.findLargestSmallerKey(5)); // -1
		printResult(12, tree.findLargestSmallerKey(12)); // 11
		printResult(11, tree.findLargestSmallerKey(11)); // 9
		printResult(14, tree.findLargestSmallerKey(14)); // 12
		printResult(17, tree.findLargestSmallerKey(17)); // 14
	}

	private static void printResult(int myNodeKey, Node result) {
		if (result != null) {
			System.out.println("answer for " + myNodeKey + " is " + result.key);
		} else {
			System.out.println(myNodeKey + " has no answer");
		}
	}

	static class Node {

		int key;
		Node left;
		Node right;
		Node parent;
	}

	static class BinarySearchTree {

		Node root;

		private void insert(int key) {
			Node myNode = new Node();
			myNode.key = key;
			if (root == null) {
				root = myNode;
			} else {
				Node parent = null, curr = root;
				while (curr != null) {
					if (curr.key == key) {
						break;
					}
					if (curr.key > key) {
						parent = curr;
						curr = curr.left;
					} else {
						parent = curr;
						curr = curr.right;
					}
				}
				myNode.parent = parent;
				if (parent.key > key) {
					parent.left = myNode;
				} else {
					parent.right = myNode;
				}
			}
		}

		private Node findLargestSmallerKey(int num) {
			Node result = null;
			Node curr = root;
			while (curr != null) {
				if (curr.key < num) {
					result = curr;
					curr = curr.right;
				} else {
					curr = curr.left;
				}
			}
			return result;
		}
	}
}
