//二叉搜索树中的两个节点被错误地交换。 
//
// 请在不改变其结构的情况下，恢复这棵树。 
//
// 示例 1: 
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// 示例 2: 
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3 
//
// 进阶: 
//
// 
// 使用 O(n) 空间复杂度的解法很容易实现。 
// 你能想出一个只使用常数空间的解决方案吗？ 
// 
// Related Topics 树 深度优先搜索 
// 👍 338 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
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

        //中序遍历，找到两个不符合升序的节点，交换他们的值。
        public void recoverTree(TreeNode root) {
            TreeNode save = null;
            TreeNode save1 = null;
            TreeNode save2 = null;
            LinkedList<TreeNode> list = new LinkedList<>();
            TreeNode node = root;
            while (node!=null || !list.isEmpty()){
                while (node!=null){
                    list.push(node);
                    node = node.left;
                }
                TreeNode pop = list.pop();
                if(save!=null && pop.val<save.val){
                    save2 = pop;
                    if(save1!=null){
                        break;
                    }else {
                        save1 = save;
                    }
                }
                save = pop;
                node = pop.right;
            }

            int tmp = save1.val;
            save1.val = save2.val;
            save2.val = tmp;
        }

        //morris遍历
        public void recoverTree2(TreeNode root) {
            TreeNode save = null;
            TreeNode save1 = null;
            TreeNode save2 = null;

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
                        if(save!=null && root.val<save.val){
                            save2 = root;
                            if(save1==null){
                                save1 = save;
                            }
                        }
                        save = root;
                        root = root.right;
                    }
                }else {
                    if(save!=null && root.val<save.val){
                        save2 = root;
                        if(save1==null){
                            save1 = save;
                        }
                    }
                    save = root;
                    root = root.right;
                }
            }

            int tmp = save1.val;
            save1.val = save2.val;
            save2.val = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}