//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1718 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        solution.mergeTwoLists(l1,l2);
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode first = new ListNode(0);
            merge(first,l1,l2);
            return first.next;
        }

        public void merge(ListNode first, ListNode l1, ListNode l2){
            if (l1 == null && l2 == null) return;
            if (l1 == null) {
                first.next = l2;
                merge(first.next, null, l2.next);
            }else if (l2 == null){
                first.next = l1;
                merge(first.next, l1.next, null);
            }else if (l1.val > l2.val){
                first.next = l2;
                merge(first.next, l1, l2.next);
            }else{
                first.next = l1;
                merge(first.next, l1.next, l2);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}