//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
// 
// Related Topics 数学 二分查找


package leetcode.editor.cn;

//Java：两数相除
public class P29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P29DivideTwoIntegers().new Solution();
        // TO TEST

        String mask = getMask(24);
        System.out.println(mask);

    }

    public static String getMask(int maskLength) {
        int mask = 0xFFFFFFFF;
        mask <<= (32 - maskLength);
        byte[] bytes = toLH(mask);
        return Byte.toUnsignedInt((byte) (mask & 0xFF)) + "." +
                Byte.toUnsignedInt(bytes[2]) + "." +
                Byte.toUnsignedInt(bytes[1]) + "." +
                Byte.toUnsignedInt(bytes[0]);
    }

    public static byte[] toLH(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        return b;
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//
//        int divide(int dividend, int divisor) {
//            if (dividend == 0) return 0;
//            if (divisor == 1) return dividend;
//            if (divisor == -1) {
//                if (dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
//                return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
//            }
//            long a = dividend;
//            long b = divisor;
//            int sign = 1;
//            if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
//                sign = -1;
//            }
//            a = a > 0 ? a : -a;
//            b = b > 0 ? b : -b;
//            long res = div(a, b);
//            if (sign > 0) return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
//            return (int) -res;
//        }
//
//        long div(long a, long b) {  // 似乎精髓和难点就在于下面这几句
//            if (a < b) return 0;
//            long count = 1;
//            long tb = b; // 在后面的代码中不更新b
//            while ((tb + tb) <= a) {
//                count = count + count; // 最小解翻倍
//                tb = tb + tb; // 当前测试的值也翻倍
//            }
//            return count + div(a - tb, b);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}