//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 762 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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
        /**
         * 求出中序遍历，然后看是否是升序数组
         */
        public boolean isValidBST(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            double min = -Double.MAX_VALUE;
            TreeNode node = root;
            while (node!=null || !list.isEmpty()){
                while (node!=null){
                    list.push(node);
                    node = node.left;
                }
                TreeNode pop = list.pop();
                if(pop.val<=min){
                    return false;
                }
                min  = pop.val;
                node = pop.right;
            }

            return true;
        }

        //用morris遍历求出中序遍历，然后看是否是升序
        public boolean isValidBST1(TreeNode root) {
            double min = -Double.MAX_VALUE;
            while (root!=null){
                if(root.left!=null){
                    TreeNode presenter = root.left;
                    while (presenter.right!=null && presenter.right!=root){
                        presenter = presenter.right;
                    }
                    if(presenter.right == null){
                        presenter.right = root;
                        root = root.left;
                    }else {
                        presenter.right = null;
                        if(root.val>min){
                            min = root.val;
                            root = root.right;
                        }else {
                            return false;
                        }
                    }
                }else {
                    if(root.val>min){
                        min = root.val;
                        root = root.right;
                    }else {
                        return false;
                    }
                }
            }
            return true;
        }

        //递归方法

        public boolean isValidBST2(TreeNode root){
            return help(root,null,null);
        }

        public boolean help(TreeNode node,Integer min ,Integer max){
            if(node == null){
                return true;
            }
            if(min!=null && node.val<=min){
                return false;
            }
            if(max!=null && node.val>=max){
                return false;
            }

            if(help(node.left,min,node.val) && help(node.right,node.val,max)){
                return true;
            }else {
                return false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}