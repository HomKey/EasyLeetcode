//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 532 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：找到字符串中所有字母异位词
public class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        // TO TEST
        solution.findAnagrams("cbaebabacd","abc");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        for (Character c : p.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        Map<Character, Integer> windows = new HashMap<>();
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        int valid = 0;

        while (right < s.length()){
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)){
                windows.put(r, windows.getOrDefault(r, 0) + 1);
                if (need.get(r).equals(windows.get(r))) valid++;
            }
            while (right - left >= p.length()){
                if (valid == need.size()) result.add(left);
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)){
                    if (need.get(l).equals(windows.get(l))) valid--;
                    windows.put(l, windows.get(l) - 1);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}