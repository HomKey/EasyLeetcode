**题意分析**
(1) 反转一个单链表，就是将从前往后的顺序变成从后往前的顺序。
(2) 反转后的链表每个节点的指向都与原链表节点相反。
*** 题目要求进阶其实提供了解题思路，还可以遍历使用辅助链表完成反转。

**方法一：循环迭代**
思路：
(1) 反转链表就是把链表所有节点指向下一个节点的指针next指向它的前一个节点。
(2) 直至遍历完所有节点，则链表反转完成。
```
class Solution {
    public ListNode reverseList(ListNode head) {
		// 判断传入节点为空或者只有一个节点，则直接返回。
		if (head == null || head.next == null){
			return head;
		}
		// 预先创建一个节点用来记录每个节点的前一个节点。
		ListNode pre = null;
		// 遍历链表的每个节点，将 next 指向前一个节点。。
		while (head != null) {
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
	}
}
```

**方法二：递归**
思路：
(1) 反转后第一个节点就是之前链表的最后一个节点(next指针指向null)。
(2) 反转后每个节点被自己的下一个节点的 next 指向。
(3) 直至递归遍历完所有节点，则链表完成反转。
```
class Solution {
    public ListNode reverseList(ListNode head) {
		// 如果当前节点为空或者是链表的最后一个节点，则直接返回。
		if (head == null || head.next == null){
			return head;
		}
		// 递归反转每个节点指向。
		ListNode p = reverseList(head.next);
		// 将每个节点的下一个节点的 next 指向自己完成反转。
		head.next.next = head;
		head.next = null;
		return p;
	}
}
```
