//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
//
// 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 98 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：不同字符的最小子序列
public class P1081SmallestSubsequenceOfDistinctCharacters{
    public static void main(String[] args) {
        Solution solution = new P1081SmallestSubsequenceOfDistinctCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;

            if(inStack[c]) continue;

            while (!stack.empty() && stack.peek() > c){
                if (count[stack.peek()] == 0) break;
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}