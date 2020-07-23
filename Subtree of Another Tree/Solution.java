/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // Corner cases
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        
        // 2 cases:
        // Case 1: Subtree begins at this level
        if(s.val == t.val) {
            if(isSameTree(s.left, t.left) && isSameTree(s.right, t.right)) return true;
        }
        
        // Case 2: Subtree begins at lower level
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
        
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        // Base cases
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;

        // Recursive calls
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
