//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。 
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 106 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics 二分查找 动态规划 
// 👍 483 👎 0


package leetcode.editor.cn;

import java.util.logging.Level;

//Java：分割数组的最大值
public class P410SplitArrayLargestSum {
    public static void main(String[] args) {
        Solution solution = new P410SplitArrayLargestSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int m) {
            // 当m为最大（==nums.length）时，最少的和是lo
            int lo = getMax(nums);
            // 当m为最小（==1）时，最大的和是hi
            int hi = getSum(nums);
            while (lo < hi){
                int mid = lo + (hi -lo) /2;
                int size = split(nums, mid);
                if (size == m){
                    hi = mid;
                }else if (size < m){
                    hi = mid;
                }else if (size > m){
                    lo = mid + 1;
                }
            }
            return lo;
        }

        /* 辅助函数，若限制最大子数组和为 max，
        计算 nums 至少可以被分割成几个子数组 */
        int split(int[] nums, int max) {
            // 至少可以分割的子数组数量
            int count = 1;
            // 记录每个子数组的元素和
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > max) {
                    // 如果当前子数组和大于 max 限制
                    // 则这个子数组不能再添加元素了
                    count++;
                    sum = nums[i];
                } else {
                    // 当前子数组和还没达到 max 限制
                    // 还可以添加元素
                    sum += nums[i];
                }
            }
            return count;
        }


        private int getMax(int[] nums) {
            int res = 0;
            for (int n : nums)
                res = Math.max(n, res);
            return res;
        }
        // 计算数组元素和
        private int getSum(int[] nums) {
            int res = 0;
            for (int n : nums)
                res += n;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}