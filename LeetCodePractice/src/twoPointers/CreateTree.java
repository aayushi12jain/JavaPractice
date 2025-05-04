package twoPointers;
//Two Sum IV - Input is a BST

public class CreateTree {
	
	TreeNode root;
	
	public void create() {
		CreateTree tree = new CreateTree();
		tree.add(10);
		tree.add(5);
		tree.add(15);
		tree.add(7);

        // Print inorder (should print 5 7 10 15)
		tree.inorder(tree.root);
	}
	
	public TreeNode insert(TreeNode root, int v) {
		if(root==null) {
			return new TreeNode(v);
		}
		if(root.val == v) {
			return root;
		}
		if(v < root.val) {
			root.left = insert(root.left,v);
		}else if(v > root.val) {
			root.right = insert(root.right,v);
		}
		return root;
	}
	
	public void add(int v) {
		root = insert(root, v);
	}
	
	public void inorder(TreeNode root) {
		if(root.left!=null) {
			root = root.left;
		}
		System.out.println(root.val);
		if(root.right!=null) {
			root = root.right;
		}
	}
	public void findTarget() {
		
		
	}
	
}