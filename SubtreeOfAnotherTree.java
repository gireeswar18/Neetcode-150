package neetcode150;

public class SubtreeOfAnotherTree {
	
	public boolean isSame(TreeNode a, TreeNode b) {
		if (a == null && b == null) return true;
		
		if (a == null || b == null) return false;
		
		if (a.val == b.val) {
			return isSame(a.left, b.left) && isSame(a.right, b.right);
		}
		
		return false;
	}
	
	public boolean isSubtree(TreeNode a, TreeNode b) {
       if (a == null) {
    	   return false;
       }
       
       if (a.val == b.val && isSame(a, b)) {
    	   return true;
       }
       
       return isSubtree(a.left, b) || isSubtree(a.right, b);
    }
}
