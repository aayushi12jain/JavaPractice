package tree;

public class BinaryTree {

	Node root;

	// Pre-order traversal: Root -> Left -> Right
	void preorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.value + " ");
		preorder(node.left);
		preorder(node.right);
	}

	// In-order traversal: Left -> Root -> Right
	void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}

	// Post-order traversal: Left -> Right -> Root
	void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value + " ");
	}
}