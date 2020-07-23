/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* sufficientSubset(TreeNode* root, int limit) {
        if (root == NULL) return root;
        // If it is a leaf, check whether val satisfies the limit. Return null => del this node.
        if (root->left == root->right) return root->val < limit ? NULL : root;
        // Divide and conquer.
        root->left = sufficientSubset(root->left, limit - root->val);
        root->right = sufficientSubset(root->right, limit - root->val);
        // If it becomes a new leaf, return null.
        return root->left == root->right ? NULL : root;
        
    }
};
