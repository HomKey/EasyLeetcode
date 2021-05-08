//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
//1 <= nums.length <= 3 * 10^4
//-2^31 <= nums[i] <= 2^31 - 1
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算


package leetcode.editor.cn;

import javax.sound.midi.Soundbank;

//Java：只出现一次的数字 II
public class P137SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new P137SingleNumberIi().new Solution();
        int i = solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99});

        System.out.println(i);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int max = 1024;
            boolean[] bitTemp = new boolean[max];
            for (int i = 0; i < nums.length; i++) {
                int index = nums[i] + 231;
                if (bitTemp[index]) bitTemp[index + (max >> 1)] = true;
                else bitTemp[index] = true;
            }
            for (int i = 0; i < max; i++) {
                if (bitTemp[i]) System.out.println(i);
            }
            for (int i = 0; i < max >> 1; i++) {
                if (bitTemp[i]) System.out.println(i);
                if (bitTemp[i] && !bitTemp[i + (max >> 1)]) return i - 231;
            }
            return Integer.MAX_VALUE;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}