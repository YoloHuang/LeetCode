//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 634 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        solution.generateTrees(3);
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



        public List<TreeNode> generateTrees(int n) {
            return getTreeNodeList(1,n);
        }
        //递归方法
        private List<TreeNode> getTreeNodeList(int start, int end) {
            List<TreeNode> treeNodes = new ArrayList<>();
            if(start>end){
                return treeNodes;
            }
            if(start==end){
                TreeNode node = new TreeNode(start);
                treeNodes.add(node);
                return treeNodes;
            }

            for (int i = start; i <=end; i++) {

                List<TreeNode> leftList = getTreeNodeList(start,i-1);
                List<TreeNode> rightList = getTreeNodeList(i+1,end);
                if(leftList.isEmpty()){
                    if(!rightList.isEmpty()){
                        for (TreeNode right: rightList) {
                            TreeNode node =new TreeNode(i);
                            node.right = right;
                            treeNodes.add(node);
                        }
                    }
                }else {
                    for (TreeNode left:leftList) {

                        if(!rightList.isEmpty()){
                            for (TreeNode right: rightList) {
                                TreeNode node =new TreeNode(i);
                                node.left = left;
                                node.right = right;
                                treeNodes.add(node);
                            }
                        }else {
                            TreeNode node =new TreeNode(i);
                            node.left = left;
                            treeNodes.add(node);
                        }
                    }
                }

            }

            return treeNodes;
        }


        //动态规划，把递归的思路转换为动态规划
        public List<TreeNode> generateTrees2(int n) {
            List<TreeNode> pre = new ArrayList<>();
            if(n ==0){
                return pre;
            }
            pre.add(null);
            for (int i = 1; i <=n; i++) {
                List<TreeNode> cur = new ArrayList<>();
                for (TreeNode node: pre) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = node;
                    cur.add(treeNode);


                    for (int j = 0; j < n; j++) {
                        TreeNode node_copy = treeCopy(node);
                        TreeNode right = node_copy;
                        for (int k = 0; k < j; k++) {
                            if(right==null){
                                break;
                            }
                            right = right.right;
                        }
                        if(right==null){
                            break;
                        }
                        treeNode = new TreeNode(i);
                        TreeNode rightTree = right.right;
                        right.right = treeNode;
                        treeNode.left = rightTree;
                        cur.add(node_copy);
                    }
                }
                pre = cur;
            }


            return pre;
        }


        private TreeNode treeCopy(TreeNode root) {
            if (root == null) {
                return root;
            }
            TreeNode newRoot = new TreeNode(root.val);
            newRoot.left = treeCopy(root.left);
            newRoot.right = treeCopy(root.right);
            return newRoot;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}