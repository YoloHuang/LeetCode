//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 270 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> answer = new ArrayList<>();
            if (root == null) return answer;
            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);
            boolean turnRight = false;
            while (!stack.isEmpty()) {
                int length = stack.size();
                Stack<TreeNode> newStack = new Stack<>();
                List<Integer> integerList = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    TreeNode node = stack.pop();
                    integerList.add(node.val);
                    if (turnRight) {
                        if (node.right != null) {

                            newStack.push(node.right);
                        }
                        if (node.left != null) {
                            newStack.push(node.left);
                        }
                    } else {
                        if (node.left != null) {

                            newStack.push(node.left);
                        }
                        if (node.right != null) {
                            newStack.push(node.right);
                        }
                    }

                }
                stack = newStack;
                answer.add(integerList);
                turnRight = !turnRight;
            }

            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}