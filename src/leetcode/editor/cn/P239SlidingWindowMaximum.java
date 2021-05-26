//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window


package leetcode.editor.cn;

import leetcode.editor.cn.bean.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：滑动窗口最大值
public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    //先填满窗口的前 k - 1
                    window.push(nums[i]);
                } else {
                    // 窗口向前滑动，加入新数字
                    window.push(nums[i]);
                    // 记录当前窗口的最大值
                    res.add(window.max());
                    // 移出旧数字
                    window.pop(nums[i - k + 1]);
                }
            }
            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }


        private class MonotonicQueue {
            LinkedList<Integer> linkedList = new LinkedList<>();

            public void push(int n){
                while (!linkedList.isEmpty() && n > linkedList.getLast()){
                    linkedList.pollLast();
                }
                linkedList.addLast(n);
            }

            public Integer max(){
                return linkedList.getFirst();
            }

            public void pop(int n){
                if (n == linkedList.getFirst()) linkedList.pollFirst();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}