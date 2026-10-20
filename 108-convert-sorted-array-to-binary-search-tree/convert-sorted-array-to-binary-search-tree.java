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
    public TreeNode sortedArrayToBST(int[] nums) {
        // Base check
        if ( nums.length == 0) {
            return null;
        }
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        // Base case: if left pointer crosses right pointer, no nodes left to process
        if (left > right) {
            return null;
        }

        // Choose the middle element as the root to ensure height-balance
        // (left + right) / 2 can overflow; this format prevents it
        int mid = left + (right - left) / 2;
        
        // Create the root node with the middle element
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left subtree using the left half of the array
        root.left = constructBST(nums, left, mid - 1);

        // Recursively build the right subtree using the right half of the array
        root.right = constructBST(nums, mid + 1, right);

        return root;
    }
}
