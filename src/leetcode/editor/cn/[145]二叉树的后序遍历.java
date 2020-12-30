//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 497 👎 0

package leetcode.editor.cn;

import java.util.*;

class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        //方法 1 递归
        List<Integer> answer = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return answer;
            }
            getAnswer(root);
            return answer;
        }

        private void getAnswer(TreeNode root) {

            if (root.left != null) {
                getAnswer(root.left);
            }
            if (root.right != null) {
                getAnswer(root.right);
            }
            answer.add(root.val);
        }

        //方法2 迭代
        public List<Integer> postorderTraversal2(TreeNode root) {
            if (root == null) {
                return answer;
            }
            Deque<TreeNode> treeNodeTrack = new LinkedList<>();
            TreeNode pre = null;
            while (!treeNodeTrack.isEmpty() || root != null) {
                while (root != null) {
                    treeNodeTrack.push(root);
                    root = root.left;
                }

                root = treeNodeTrack.pop();
                if (root.right == null || root.right == pre) {
                    answer.add(root.val);
                    pre = root;
                    root = null;
                } else {
                    treeNodeTrack.push(root);
                    root = root.right;
                }
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}