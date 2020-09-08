//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 890 👎 0

package leetcode.editor.cn;

class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
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

        //暴力解法，先冒泡排序，然后从最小值开始获取值，然后再一次排序
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length<=0){
                return null;
            }
            //冒泡排序
            lists = quick(lists);

            return getNext(lists,0);
        }

        public ListNode getNext(ListNode[] lists,int start){
            if(start>=lists.length){
                return null;
            }
            if(lists[start]==null){
                return getNext(lists,start+1);
            }
            ListNode answer = new ListNode();
            answer.val = lists[start].val;
            if(lists[start].next!=null){
                lists[start] = lists[start].next;
                for (int i = start; i < lists.length-1; i++) {
                    if(lists[i+1].val<lists[i].val){
                        ListNode node = lists[i];
                        lists[i] = lists[i+1];
                        lists[i+1] = node;
                    }
                }
                answer.next = getNext(lists,start);
            }else {
                answer.next = getNext(lists,start+1);
            }
            return answer;
        }

        public ListNode[] quick(ListNode[] list){
            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list.length-1-i; j++) {
                    if(list[j]==null){
                        continue;
                    }
                    if (list[j+1]==null || list[j+1].val<list[j].val){
                        ListNode node = list[j];
                        list[j] = list[j+1];
                        list[j+1] = node;
                    }
                }
            }
            return list;
        }


        //两两合并
        public ListNode mergeKLists2(ListNode[] lists) {
            if(lists.length<=0){
                return null;
            }

            return getMerge(lists);
        }

        private ListNode getMerge(ListNode[] lists) {
            int length = lists.length;
            ListNode[] nodes;
            ListNode merge;
            if(length==1){
                return lists[0];
            }else if(length>1){
                if(length%2==1){
                    nodes  = new ListNode[(length+1)/2];
                    int count= 0;
                    ListNode listNode = lists[length-1];
                    for (int i = 0; i < length-1; i=i+2) {
                        nodes[count] = mergeTwoLists(lists[i],lists[i+1]);
                        count++;
                    }
                    nodes[count] = listNode;
                }else {
                    nodes = new ListNode[length/2];
                    int count = 0;
                    for (int i = 0; i < length-1; i=i+2) {
                        nodes[count] = mergeTwoLists(lists[i],lists[i+1]);
                        count++;
                    }
                }
                return getMerge(nodes);
            }else {
                return null;
            }
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1==null && l2 ==null){
                return null;
            }
            if(l1==null){
                return l2;
            }
            if(l2==null){
                return l1;
            }
            ListNode answer = new ListNode();
            if(l1.val>=l2.val){
                answer.val = l2.val;
                answer.next = mergeTwoLists(l1,l2.next);
            }else {
                answer.val = l1.val;
                answer.next = mergeTwoLists(l1.next,l2);
            }
            return answer;
        }


    }




//leetcode submit region end(Prohibit modification and deletion)


}