//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 递归 
// 👍 830 👎 0

package leetcode.editor.cn;

class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {

            getGain(root);
            return max;
        }

        //用递归的方法，求每个节点的最大贡献值
        //这个最大贡献值等于：叶子节点等于自身大小，根节点等于 自身大小+子节点中最大值（如果小于0就为0）。
        private int getGain(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = Math.max(getGain(root.left), 0);
            int right = Math.max(getGain(root.right), 0);

            //这里求每个节点的最大路径和 ，节点的最大路径和，等于该节点的值+ 左边的贡献值与右边的贡献值（这其中如果贡献值小于0就设为0，意思是不走这过了）
            max = Math.max(max, root.val + left + right);


            return root.val + Math.max(left, right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}