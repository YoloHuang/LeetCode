//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 724 👎 0

package leetcode.editor.cn;
class InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    //简单的递归
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        invert(root);


        return root;

    }

    private void invert(TreeNode root) {
        if(root!=null){
            TreeNode save = root.left;
            root.left = root.right;
            root.right = save;

            invert(root.left);
            invert(root.right);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  
}