//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
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
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 537 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：去除重复字母
public class P316RemoveDuplicateLetters{
    public static void main(String[] args) {
        Solution solution = new P316RemoveDuplicateLetters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean[] inStack = new boolean[256];

        for (char c :s.toCharArray()){
            count[c]--;
            if (inStack[c]) continue;

            while (!stack.empty() && stack.peek() > c){
                if (count[stack.peek()]==0) break;
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