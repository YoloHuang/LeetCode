//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 885 👎 0

package leetcode.editor.cn;

class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
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

        TreeNode answer = null;

        //使用递归。用一个函数Fx代表当前节点中是否包含p节点或者q节点。那么符合条件的最近公共祖先满足：
        // (lson && rson) ||((x = p || x = q) && (lson || rson))
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            getFx(root, p, q);
            return answer;
        }

        public boolean getFx(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return false;
            boolean lson = getFx(root.left, p, q);
            boolean rson = getFx(root.right, p, q);
            if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
                answer = root;
            }
            return lson || rson || root.val == p.val || root.val == q.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}