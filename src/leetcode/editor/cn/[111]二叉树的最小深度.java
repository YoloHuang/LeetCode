//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 425 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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

        //思路与最大深度差不多，只不过中间提前判断当前节点是否是最小深度
        public int minDepth(TreeNode root) {

            int answer = 0;
            if (root == null) {
                return answer;
            }
            Queue<TreeNode> list = new LinkedList<>();
            list.offer(root);
            while (!list.isEmpty()) {
                int length = list.size();
                for (int i = 0; i < length; i++) {
                    TreeNode node = list.poll();
                    if (node.right == null && node.left == null) {
                        return answer + 1;
                    }
                    if (node.left != null) {
                        list.offer(node.left);
                    }
                    if (node.right != null) {
                        list.offer(node.right);
                    }
                }
                answer += 1;
            }
            return answer;

        }

        //递归，递归的思路就是，找到子节点的最小深度，然后+1

    }
//leetcode submit region end(Prohibit modification and deletion)


}