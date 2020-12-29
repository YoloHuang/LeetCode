//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 672 👎 0


package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
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

        //使用栈来存储后续的位置，使用pre来存储前一个位置，2MS 时间太长
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode pre = null;
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                if (pre != null) {
                    pre.right = node;
                    pre.left = null;
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                pre = node;
            }
        }

        //前序遍历，然后读取
        List<TreeNode> list = new ArrayList<>();
        public void flatten2(TreeNode root) {
            preTraversal(root);

            for (int i = 1; i < list.size(); i++) {
                TreeNode pre = list.get(i-1);
                TreeNode cur = list.get(i);
                pre.left = null;
                pre.right = cur;
            }
        }

        private void preTraversal(TreeNode root) {
            if(root!=null){
                list.add(root);
                preTraversal(root.left);
                preTraversal(root.right);
            }
        }


        //递归 使用一个方法，将当前节点操作为一个单链表，并且返回最后节点的值
        public void flatten3(TreeNode root) {
            change(root);
        }

        private TreeNode change(TreeNode root) {
            if(root ==null){
                return null;
            }
            if (root.left == null && root.right == null){
                return root;
            }
            else if (root.left == null){
                return change(root.right);
            }else if(root.right == null){
                root.right = root.left;
                root.left = null;
                return change(root.right);
            }else {
                TreeNode left = change(root.left);
                TreeNode save = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode another = change(save);
                left.right = save;
                return another;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}