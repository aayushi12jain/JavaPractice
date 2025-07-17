package tree;

public class TreeUsage {

	public void createTree() {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Manually creating the binary tree
		//        1
		//       / \
		//      2   3
		//     / \
		//    4   5
		System.out.println("Pre-order traversal:");
		tree.preorder(tree.root); // Output: 1 2 4 5 3

		System.out.println("\nIn-order traversal:");
		tree.inorder(tree.root); // Output: 4 2 5 1 3

		System.out.println("\nPost-order traversal:");
		tree.postorder(tree.root); // Output: 4 5 2 3 1
		
		BinarySearchTree bst = new BinarySearchTree();

        // Insert values into the BST
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int val : values) {
            bst.root = bst.insert(bst.root, val);
        }

        System.out.println("In-order traversal of BST:");
        bst.inorder(bst.root); // Output: 1 3 4 6 7 8 10 13 14

        // Search for a value
        int key = 7;
        System.out.println("\n\nIs " + key + " in the BST? " + bst.search(bst.root, key)); // true

        key = 5;
        System.out.println("Is " + key + " in the BST? " + bst.search(bst.root, key));
	}
}
