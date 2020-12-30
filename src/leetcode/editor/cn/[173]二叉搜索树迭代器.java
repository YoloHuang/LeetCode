//实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。 
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。 
//
// 
//
// 示例： 
//
// 
//
// BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // 返回 3
//iterator.next();    // 返回 7
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 9
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 15
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 20
//iterator.hasNext(); // 返回 false 
//
// 
//
// 提示： 
//
// 
// next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。 
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。 
// 
// Related Topics 栈 树 设计 
// 👍 305 👎 0

package leetcode.editor.cn;

import java.util.Stack;

class BinarySearchTreeIterator {
    public static void main(String[] args) {

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
    class BSTIterator {
        //第一种方法是使用一个list存储中序遍历，然后用一个index来标记最新可以获取到的值就行了。
        //第二种方法是使用堆栈来存储，这样最大使用空间只有h(h是树的高度)

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            initStack(root);
        }

        private void initStack(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                initStack(node.right);
            }
            return node.val;
        }

        public boolean hasNext() {
            return stack.size() > 0;
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)


}