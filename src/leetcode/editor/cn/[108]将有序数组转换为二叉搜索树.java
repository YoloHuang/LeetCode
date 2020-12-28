//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 665 👎 0

package leetcode.editor.cn;
class ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int length = nums.length;
        return getNode(nums,0,length);
    }

    private TreeNode getNode(int[] nums, int start, int length) {
        if(length<=0){
            return null;
        }
        TreeNode treeNode = new TreeNode();
        int center = start + length/2;
        treeNode.val = nums[center];
        treeNode.left = getNode(nums,start,length/2);
        treeNode.right = getNode(nums,center+1,length-length/2-1);
        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
}