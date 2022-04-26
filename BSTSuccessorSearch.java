import java.io.*;
import java.util.*;

public class BSTSuccessorSearch {

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
	    
	    printResult(20, tree.findSuccessor(tree.search(20))); // 25
	 	printResult(9, tree.findSuccessor(tree.search(9))); // 11
		printResult(25, tree.findSuccessor(tree.search(25))); // null
		printResult(5, tree.findSuccessor(tree.search(5))); // 9
		printResult(12, tree.findSuccessor(tree.search(12))); // 14
		printResult(11, tree.findSuccessor(tree.search(11))); // 12
		printResult(14, tree.findSuccessor(tree.search(14))); // 20
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

		private Node search(int key) {
			Node found = null, curr = root;
			while (curr != null) {
				if (curr.key == key) {
					found = curr;
					break;
				}
				if (curr.key > key) {
					curr = curr.left;
				} else {
					curr = curr.right;
				}
			}
			return found;
		}

		private Node findSuccessor(Node myNode) {
			if (myNode.right != null) {
				return findMinimum(myNode.right);
			} else {
				Node curr = myNode, parent = curr.parent;
				while (parent != null && parent.left != curr) {
					curr = parent;
					parent = curr.parent;
				}
				return parent;
			}
		}

		private Node findMinimum(Node root) {
			if (root.left != null) {
				return findMinimum(root.left);
			}
			return root;
		}
	}
}