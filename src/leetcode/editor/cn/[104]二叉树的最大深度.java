//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 708 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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

        //BFS 广度优先搜索方法。时间1ms
        public int maxDepth(TreeNode root) {
            int answer = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            if(root==null) return answer;
            queue.offer(root);
            while (!queue.isEmpty()){
                int length = queue.size();

                for (int i = 0; i < length; i++) {
                    TreeNode node = queue.poll();
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
                answer++;
            }
            return answer;
        }


        //递归
        public int maxDepth2(TreeNode root){
            if(root==null){
                return 0;
            }else {
                int left = maxDepth2(root.left);
                int right = maxDepth2(root.right);
                return Math.max(left,right)+1;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}