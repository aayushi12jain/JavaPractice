package tree;

public class BinarySearchTree {
	Node root;

	Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}

		if (value < node.value) {
			node.left = insert(node.left, value);
		} else if (value > node.value) {
			node.right = insert(node.right, value);
		}

		return node;
	}

	// Search for a value in the BST
	boolean search(Node node, int key) {
		if (node == null) {
			return false;
		}

		if (key == node.value) {
			return true;
		} else if (key < node.value) {
			return search(node.left, key);
		} else {
			return search(node.right, key);
		}
	}

	// In-order traversal: prints in sorted order
	void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}

}
