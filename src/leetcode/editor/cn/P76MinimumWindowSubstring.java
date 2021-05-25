//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1168 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最小覆盖子串
public class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
        solution.minWindow("ADOBECODEBANC", "ABC");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> windows = new HashMap<>(), need = new HashMap<>();
            // 统计需要的子串
            for (Character c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
            // 窗口索引
            int left = 0, right = 0;
            // 记录多少个char符合
            int valid = 0;
            // 记录最小覆盖子串的起始索引及长度
            int start = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                // c 是将移入窗口的字符
                char c = s.charAt(right);
                // 右移窗口
                right++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (need.get(c).equals(windows.get(c))) valid++;
                }
                // 判断左侧窗口是否要收缩
                while (valid == need.size()) {
                    // 在这里更新最小覆盖子串
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    // d 是将移出窗口的字符
                    char d = s.charAt(left);
                    // 左移窗口
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (need.get(d).equals(windows.get(d))) {
                            valid--;
                        }
                        windows.put(d, windows.get(d) - 1);
                    }
                }
            }
            // 返回最小覆盖子串
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}