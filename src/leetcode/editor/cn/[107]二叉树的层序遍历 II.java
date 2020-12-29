//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 377 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
        //思路与102相同，这里是倒序遍历，那么就用链表的形式，在头部添加list
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> answer = new LinkedList<>();
            if (root == null) return answer;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int length = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                answer.add(0, list);
            }
            return answer;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}