//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 397 👎 0


package leetcode.editor.cn;

import org.w3c.dom.css.ElementCSSInlineStyle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PrimitiveIterator;

class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
        List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return answer;
            }
            LinkedList<Integer> list = new LinkedList<>();
            pathSum2(root, sum, list);
            return answer;
        }

        private void pathSum2(TreeNode root, int sum, LinkedList<Integer> list) {
            list.add(root.val);
            if (root.left == null && root.right == null && sum == root.val) {
                LinkedList<Integer> list2 = new LinkedList<>(list);
                answer.add(list2);
            }
            if (root.left != null) {
                pathSum2(root.left, sum - root.val, list);
            }

            if (root.right != null) {
                pathSum2(root.right, sum - root.val, list);
            }
            list.pollLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}