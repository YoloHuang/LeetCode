//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 270 👎 0

package leetcode.editor.cn;

class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int answer = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return answer;
            }

            if (root.left != null) {
                if (root.left.right == null && root.left.left == null) {
                    answer += root.left.val;
                } else {
                    sumOfLeftLeaves(root.left);
                }
            }
            if (root.right != null) {
                sumOfLeftLeaves(root.right);
            }

            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}