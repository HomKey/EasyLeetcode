//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2^31 <= x <= 2^31 - 1
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1492 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：回文数
public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            // 负数或者个位数为0绝不可能为回文数
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;
            int tmp = 0;
            while (x > tmp){
                tmp = tmp*10 + x%10;
                x /= 10;
            }
            return x == tmp || x == tmp / 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}