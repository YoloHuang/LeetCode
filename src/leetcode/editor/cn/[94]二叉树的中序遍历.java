//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 713 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        List<Integer> answer = new ArrayList<>();

        //递归方法
        public List<Integer> inorderTraversal(TreeNode root) {

            if(root!=null){
                inorderTraversal(root.left);
                answer.add(root.val);
                inorderTraversal(root.right);
            }
            return answer;
        }

        //用栈的方式存储还没有打印的节点
        public List<Integer> inorderTraversal2(TreeNode root){
            LinkedList<TreeNode> save = new LinkedList<>();
            TreeNode node = root;
            while (node!=null || !save.isEmpty()){
                if(node!=null){
                    save.push(node);
                    node = node.left;
                }else {
                    TreeNode treeNode = save.pop();
                    answer.add(treeNode.val);
                    node = treeNode.right;
                }
            }

            return answer;
        }

        public List<Integer> inorderTraversal3(TreeNode root){
            while (root!=null){
                if(root.left!=null){
                    TreeNode presenter = root.left;
                    while (presenter.right!=null && presenter.right!=root){
                        presenter = presenter.right;
                    }

                    if(presenter.right==null){
                        presenter.right = root;
                        root = root.left;
                    }else {
                        answer.add(root.val);
                        presenter.right = null;
                        root = root.right;
                    }
                }else {
                    answer.add(root.val);
                    root = root.right;
                }
            }

            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}