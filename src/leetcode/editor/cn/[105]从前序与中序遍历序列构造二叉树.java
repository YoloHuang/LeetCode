//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 686 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        HashMap<Integer,Integer> map = new HashMap<>();


        //思路，根据前序遍历找到root，在中序中找到root，那么中序遍历中root左边就是left的中序遍历，右边就是right的中序遍历。
        //再用递归的方式，对左边右边再次判断
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder==null || preorder.length == 0 || preorder.length != inorder.length){
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return  getTree(preorder,0,0,preorder.length);

        }

        private TreeNode getTree(int[] preorder, int preStart, int inStart,int length) {
            if(length<=0){
                return null;
            }
            TreeNode root = new TreeNode();
            root.val = preorder[preStart];
            int index = map.get(root.val);
            int leftLength = index-inStart;
            int rightLength = length-leftLength-1;
            root.left = getTree(preorder,preStart+1,inStart,leftLength);
            root.right = getTree(preorder,preStart+1+leftLength,index+1,rightLength);
            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}