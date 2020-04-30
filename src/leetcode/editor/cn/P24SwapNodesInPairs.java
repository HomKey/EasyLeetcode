//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


package leetcode.editor.cn;

import leetcode.editor.cn.bean.ListNode;

//Java：两两交换链表中的节点
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
        // TO TEST
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        solution.swapPairs(listNode);
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
//        给定 1->2->3->4, 你应该返回 2->1->4->3.

        /**
         * 1 2 3 4
         * 0 -> 1 - 2  3 4
         * 3 4
         *
         *
         *
         * @param head
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode cur = pre;
            while (cur.next != null && cur.next.next != null){
                // 先记录交换的2个点
                ListNode start = cur.next;
                ListNode end = cur.next.next;
                // start end [other]
                // cur end [other]
                cur.next = end;
                // start [other]
                // cur end [other]
                start.next = end.next;
                // cur end start [other]
                end.next = start;
                cur = start;
                // cur [start, end, other]
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}