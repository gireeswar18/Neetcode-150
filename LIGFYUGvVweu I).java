package neetcode150;

public class SubtreeOfAnotherTree {

	public boolean isSame(TreeNode a, TreeNode b) {

	}

	public boolean isSubtree(TreeNode a, TreeNode b) {
       if (a == null) {
    	   return false;
       }
       
       if (a.val == b.val && isSame(a, b)) {
    	   return true;
       }
       
       return isSubtree(a, b);
       
	}
}
