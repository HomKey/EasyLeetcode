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
import java.util.List;

//Java：滑动窗口最大值
public class P239SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}