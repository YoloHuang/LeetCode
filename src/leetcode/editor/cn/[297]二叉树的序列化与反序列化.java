//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 441 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        String s = "4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2";
        TreeNode node = ser.deserialize(s);
        TreeNode ans = deser.deserialize(ser.serialize(node));


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
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isDeep = false;
            while (!queue.isEmpty()) {
                if (isDeep) {
                    queue.clear();
                }
                isDeep = true;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        stringBuilder.append("null,");
                    } else {
                        stringBuilder.append(node.val).append(",");
                        if (node.right != null || node.left != null) {
                            isDeep = false;
                        }
                        queue.offer(node.left);
                        queue.offer(node.right);

                    }
                }
            }


            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] list = data.split(",");
            LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(list));

            return deserialize(linkedList);
        }

        private TreeNode deserialize(LinkedList<String> linkedList) {
            if (linkedList.get(0) == null || linkedList.get(0).equals("")) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            String first = linkedList.poll();
            TreeNode root = new TreeNode(Integer.valueOf(first));
            queue.offer(root);
            while (!queue.isEmpty() && !linkedList.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    String left = linkedList.poll();
                    String right = linkedList.poll();
                    if (!"null".equals(left) && left != null) {
                        TreeNode leftNode = new TreeNode(Integer.valueOf(left));
                        node.left = leftNode;
                        queue.offer(leftNode);
                    }
                    if (!"null".equals(right) && right != null) {
                        TreeNode rightNode = new TreeNode(Integer.valueOf(right));
                        node.right = rightNode;
                        queue.offer(rightNode);
                    }
                }

            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


}