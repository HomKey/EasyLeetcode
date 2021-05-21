//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计 
// 👍 416 👎 0


package leetcode.editor.cn;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：数据流的中位数
public class P295FindMedianFromDataStream {
    public static void main(String[] args) {
//        Solution solution = new P295FindMedianFromDataStream().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        // 小顶堆 存较大的数据
        private Queue<Integer> small;
        // 大顶堆 存较小的数据
        private Queue<Integer> big;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            small = new PriorityQueue<>();
            big = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        public void addNum(int num) {
            if (small.size() >= big.size()){
                small.offer(num);
                big.offer(small.poll());
            }else{
                big.offer(num);
                small.offer(big.poll());
            }
        }

        public double findMedian() {
            if (small.size() == 0 && big.size() == 0) return 0;
            if (small.size() > big.size()) {
                return small.peek();
            } else if (small.size() < big.size()) {
                return big.peek();
            } else {
                return (small.peek() + big.peek()) / 2.0;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}