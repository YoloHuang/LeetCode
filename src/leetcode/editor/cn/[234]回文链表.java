//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 935 👎 0

package leetcode.editor.cn;

class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //思路：用快慢指针找到中间点，对后部分做翻转。比较前后是否相等。比较完之后翻转后部分。
        //思路2：存储到list中，比较list。
        //思路3：
        public boolean isPalindrome(ListNode head) {
            ListNode leftHead = head;
            ListNode centerNode = getCenterNode(head);
            ListNode rightHead = reverseList(centerNode.next);
            ListNode rightSave = rightHead;
            while (rightSave!=null){
                if(leftHead.val != rightSave.val){
                    centerNode.next = reverseList(rightHead);
                    return false;
                }
                leftHead = leftHead.next;
                rightSave = rightSave.next;
            }
            centerNode.next = reverseList(rightHead);
            return true;
        }

        public ListNode reverseList(ListNode head) {
            ListNode cur = head,pre = null;
            while (cur!=null){
                ListNode next = cur.next;
                cur.next = pre;
                pre =cur;
                cur = next;
            }
            return pre;
        }

        public ListNode getCenterNode(ListNode head) {
            ListNode slowNode = head,quickNode = head;
            while (quickNode!=null && quickNode.next !=null){
                if(quickNode.next.next == null){
                    return slowNode;
                }
                slowNode = slowNode.next;
                quickNode = quickNode.next.next;
            }
            return slowNode;
        }
        // 思路： 找到中间节点，在找的过程中，将前半部分翻转，比较前后。
        public boolean isPalindrome2(ListNode head) {
            if(head == null || head.next ==null){
                return true;
            }
            ListNode slow = head,fast = head,pre = head,prepre = null;
            while (fast!=null && fast.next !=null){
                pre = slow;
                pre.next = prepre;
                prepre = pre;
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast!=null){
                slow =slow.next;
            }
            while (pre!=null && slow !=null){
                if(pre.val!=slow.val){
                    return false;
                }
                pre = pre.next;
                slow = slow.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}