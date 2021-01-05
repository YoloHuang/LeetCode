//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 421 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        List<String> answer = new ArrayList<>();
        List<TreeNode> save = new LinkedList<>();

        public List<String> binaryTreePaths(TreeNode root) {

            if (root == null) {
                return answer;
            }

            saveTree(root);

            return answer;
        }

        private void saveTree(TreeNode root) {
            save.add(root);
            if (root.left == null && root.right == null) {
                saveString();
            }
            if (root.left != null) {
                saveTree(root.left);
            }
            if (root.right != null) {
                saveTree(root.right);
            }
            save.remove(root);
        }

        private void saveString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < save.size() - 1; i++) {
                s.append(save.get(i).val).append("->");
            }
            s.append(save.get(save.size() - 1).val);
            answer.add(s.toString());
        }


        public List<String> binaryTreePaths2(TreeNode root) {
            List<String> answer = new ArrayList<>();
            saveTree2(root, "", answer);

            return answer;
        }

        private void saveTree2(TreeNode root, String s, List<String> answer) {
            if (root != null) {
                StringBuilder builder = new StringBuilder(s);
                builder.append(root.val);
                if (root.right == null && root.left == null) {
                    answer.add(builder.toString());
                } else {
                    builder.append("->");
                    saveTree2(root.left, builder.toString(), answer);
                    saveTree2(root.right, builder.toString(), answer);
                }
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}