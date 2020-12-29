//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 406 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        solution.buildTree(inorder, postorder);
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
        HashMap<Integer, Integer> map = new HashMap<>();

        //思路与105题一样，先根据后序遍历，get到root点，然后在中序遍历中查询root点位置，再左右进行递归
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || inorder.length == 0 || inorder.length != postorder.length) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return getTree(postorder, inorder.length - 1, postorder.length - 1, inorder.length);
        }

        private TreeNode getTree(int[] postorder, int inEnd, int postEnd, int length) {
            if (length <= 0) {
                return null;
            }
            TreeNode node = new TreeNode(postorder[postEnd]);

            int index = map.get(postorder[postEnd]);
            node.left = getTree(postorder, index - 1, index + postEnd - inEnd - 1, length - inEnd + index - 1);
            node.right = getTree(postorder, inEnd, postEnd - 1, inEnd - index);

            return node;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}