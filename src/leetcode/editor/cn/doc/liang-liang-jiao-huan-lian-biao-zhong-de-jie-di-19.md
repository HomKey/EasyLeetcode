####  方法一：递归
这个题目要求我们从第一个节点开始两两交换链表中的节点，且要真正的交换节点。

**算法：**

- 从链表的头节点 `head` 开始递归。
- 每次递归都负责交换一对节点。由 `firstNode` 和 `secondNode` 表示要交换的两个节点。
- 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
- 交换了两个节点以后，返回 `secondNode`，因为它是交换后的新头。
- 在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点。

```python [solution1-Python]
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def swapPairs(self, head: ListNode) -> ListNode:
        """
        :type head: ListNode
        :rtype: ListNode
        """

        # If the list has no node or has only one node left.
        if not head or not head.next:
            return head

        # Nodes to be swapped
        first_node = head
        second_node = head.next

        # Swapping
        first_node.next  = self.swapPairs(second_node.next)
        second_node.next = first_node

        # Now the head is the second node
        return second_node
```

```java [solution1-Java]
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
```

**复杂度分析**

* 时间复杂度：*O(N)*，其中 *N* 指的是链表的节点数量。
* 空间复杂度：*O(N)*，递归过程使用的堆栈空间。


####  方法二：迭代
我们把链表分为两部分，即奇数节点为一部分，偶数节点为一部分，`A` 指的是交换节点中的前面的节点，`B` 指的是要交换节点中的后面的节点。在完成它们的交换，我们还得用 `prevNode` 记录 `A` 的前驱节点。

**算法：**

1. `firstNode（即 A）` 和 `secondNode（即 B）` 分别遍历偶数节点和奇数节点，即两步看作一步。
2. 交换两个节点：

```
 firstNode.next = secondNode.next
 secondNode.next = firstNode
```

3. 还需要更新 `prevNode.next` 指向交换后的头。

```
prevNode.next = secondNode
```

 4. 迭代完成后得到最终的交换结果。


```python [solution2-Python]
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # Dummy node acts as the prevNode for the head node
        # of the list and hence stores pointer to the head node.
        dummy = ListNode(-1)
        dummy.next = head

        prev_node = dummy

        while head and head.next:

            # Nodes to be swapped
            first_node = head;
            second_node = head.next;

            # Swapping
            prev_node.next = second_node
            first_node.next = second_node.next
            second_node.next = first_node

            # Reinitializing the head and prev_node for next swap
            prev_node = first_node
            head = first_node.next

        # Return the new head node.
        return dummy.next
```

```java [solution2-Java]
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}
```

**复杂度分析**

* 时间复杂度：*O(N)*，其中 *N* 指的是链表的节点数量。
* 空间复杂度：*O(1)*。