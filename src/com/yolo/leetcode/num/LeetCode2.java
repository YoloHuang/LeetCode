package com.yolo.leetcode.num;

public class LeetCode2 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */




    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,null);
    }

    public ListNode addTwoNumbers(ListNode p,ListNode q,ListNode mNode){
        ListNode answer = new ListNode(0);
        int a=0,b=0,c=0;
        if(p!=null){
            a = p.val;
        }
        if(q!=null){
            b = q.val;
        }
        c = a+b;
        ListNode newNode = new ListNode(c);
        if(mNode!=null){
            mNode.next = newNode;
            if(mNode.val>9){
                mNode.val = mNode.val%10;
                newNode.val+=1;
            }
        }
        /**
         * 如果p,q 都不为空，判断是否有一个存在next，如果都不存在，则需要计算当前位数是否大于9，来自动生成最高位。
         * 如果p,q中有一个为空，另一个不为空且有下一位，则继续计算。
         * 如果都为空，只需要计算当前位数是否大于9即可。
         */
        if(p!=null && q!=null){
            if(p.next!=null || q.next!=null){
                newNode.next = addTwoNumbers(p.next,q.next,newNode);
            }else if(newNode.val>9){
                answer.val = newNode.val/10;
                newNode.val = newNode.val%10;
                newNode.next = answer;
            }
        }else if(p!=null && p.next!=null){
            newNode.next = addTwoNumbers(p.next,null,newNode);
        }else if(q!=null && q.next!=null){
            newNode.next = addTwoNumbers(null,q.next,newNode);
        }else if(newNode.val>9){
            answer.val = newNode.val/10;
            newNode.val = newNode.val%10;
            newNode.next = answer;
        }
        return newNode;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
