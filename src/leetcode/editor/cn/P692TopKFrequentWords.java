//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 261 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：前K个高频单词
public class P692TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new P692TopKFrequentWords().new Solution();
        // TO TEST
        solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Node {
            private String word;
            private int count;

            public Node(String word, int count) {
                this.word = word;
                this.count = count;
            }

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        private Queue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            int res = o2.count - o1.count;
            return res == 0 ? o1.word.compareTo(o2.word) : res;
        });

        private Map<String, Integer> map = new HashMap<>();

        public List<String> topKFrequent(String[] words, int k) {
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            map.forEach((key, val) -> {
                queue.add(new Node(key, val));
            });
            List<String> list = new ArrayList<>(k);
            for (int i = 0; i < k; i++) {
                Node node = queue.poll();
                if (node != null) list.add(node.getWord());
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}