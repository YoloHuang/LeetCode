//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找 
// 👍 409 👎 0

package leetcode.editor.cn;

class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
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
        //不考虑完全二叉树的话，直接递归或者广度搜索
        //这里要利用上完全二叉树的特点，直接算最后一层的数量。最后一层的计算，使用位运算。最左边和最右边分别是1000，1111。
        // 忽略掉第一个1的话，后面的0代表左边，1代表右边。那我们可以用二分法来找到最后一层的最后一个数，从而找到所有的数。
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            }
            int level = 0;
            TreeNode node = root;
            while (node.left!=null){
                level++;
                node = node.left;
            }
            //最底层中，最左边的节点是第min个节点，右边铺满后，最右边是第max个节点。
            int min = 1 << level,max = (1<<(level+1))-1;
            //那么现在问题就变成了，在min和max中找到最后存在的节点

            while (min<max){
                int mid = (max-min+1)/2+min;
                if(exists(root,mid,level)){
                    min  = mid;
                }else {
                    max = mid-1;
                }
            }
            return min;

        }

        private boolean exists(TreeNode root, int mid,int level) {
            int bits = 1<< (level-1);
            TreeNode node = root;
            while (node!=null && bits>0){
                if((bits & mid) ==0 ){
                    node = node.left;
                }else {
                    node = node.right;
                }
                bits >>= 1;
            }
            return node!=null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}