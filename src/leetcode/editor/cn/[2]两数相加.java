//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4743 👎 0

package leetcode.editor.cn;

class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return getPlus(0,l1,l2);
        }

        ListNode getPlus(int d,ListNode l1,ListNode l2){
            int a= 0,b =0,x =0;
            if(l1==null && l2 == null){
                if(d ==1){
                    return new ListNode(1);
                }else {
                    return null;
                }

            }
            if(l1!=null){
                a = l1.val;
            }else {
                l1 =new ListNode(0);
            }
            if (l2!=null){
                b = l2.val;
            }else {
                l2 = new ListNode(0);
            }
            int c = a+b+d;
            if(c>9){
                c = c-10;
                x = 1;
            }
            ListNode node =new ListNode(c);
            node.next = getPlus(x,l1.next,l2.next);
            return node;
        }

        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


}