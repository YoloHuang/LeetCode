//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找 
// 👍 330 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
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
        //简单求中序遍历，后获取第k个元素
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = inorderTraversal(root);
            return list.get(k - 1);
        }

        List<Integer> answer = new ArrayList<>();

        //用栈的方式存储还没有打印的节点
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<TreeNode> save = new LinkedList<>();
            TreeNode node = root;
            while (node != null || !save.isEmpty()) {
                if (node != null) {
                    save.push(node);
                    node = node.left;
                } else {
                    TreeNode treeNode = save.pop();
                    answer.add(treeNode.val);
                    node = treeNode.right;
                }
            }

            return answer;
        }


        //迭代方法
        public int kthSmallest2(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            while (true) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (--k == 0) return root.val;
                root = root.right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}