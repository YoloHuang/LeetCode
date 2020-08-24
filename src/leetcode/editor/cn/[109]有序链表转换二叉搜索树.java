//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 318 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
        //方法1，转换为list后，直接去中间值
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head!=null){
                list.add(head.val);
                head = head.next;
            }
            return getNode(list,0,list.size()-1);
        }

        private TreeNode getNode(List<Integer> list,int start,int end) {
            if(start>end){return null;}
            int center = start+(end-start)/2;
            TreeNode node = new TreeNode(list.get(center));
            node.left = getNode(list,start,center-1);
            node.right = getNode(list,center+1,end);
            return node;
        }

        //方法2  快慢指针法
        public TreeNode sortedListToBST2(ListNode head) {
            if(head==null){
                return null;
            }
            if(head.next == null){
                return new TreeNode(head.val);
            }
            ListNode slow = head,quick = head,center = null;
            while (quick!=null&& quick.next!=null){
                center = slow;
                slow = slow.next;
                quick = quick.next.next;
            }
            center.next = null;
            TreeNode node = new TreeNode(slow.val);
            node.left = sortedListToBST2(head);
            node.right = sortedListToBST2(slow.next);


            return node;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}