//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 353 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：字符串的排列
public class P567PermutationInString{
    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();
        // 统计需要的子串
        for (Character c : s1.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        // 窗口索引
        int left = 0, right = 0;
        // 记录多少个char符合
        int valid = 0;
        while (right < s2.length()){
            char r = s2.charAt(right);
            right++;
            if (need.containsKey(r)){
                windows.put(r, windows.getOrDefault(r, 0) + 1);
                if (need.get(r).equals(windows.get(r))) valid++;
            }
            while (right - left >= s1.length()){
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()) return true;
                char l = s2.charAt(left);
                left++;
                if (need.containsKey(l)){
                    if (need.get(l).equals(windows.get(l))) valid--;
                    windows.put(l, windows.get(l) - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}