//给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。 
//
// 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说
//，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。 
//
// 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。 
// perm[0] = encoded[1] XOR encoded[3] 1 3 5
// 
//perm[0] XOR perm[encoded.length-1]
// 示例 1： 
//
// 输入：encoded = [3,1]
//输出：[1,2,3]
//解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
// 
//
// 示例 2： 
//
// 输入：encoded = [6,5,4,6]
//输出：[2,4,1,5,3]
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n < 105 
// n 是奇数。 
// encoded.length == n - 1 
// 
// Related Topics 位运算 
// 👍 59 👎 0


package leetcode.editor.cn;
//Java：解码异或后的排列
public class P1734DecodeXoredPermutation{
    public static void main(String[] args) {
        Solution solution = new P1734DecodeXoredPermutation().new Solution();
        // TO TEST
        solution.decode(new int[]{3,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 3 1
    public int[] decode(int[] encoded) {

        int encodedAll = 0; // 2
        for (int i = 1; i <= encoded.length+1; i++) {
            encodedAll ^= i;
        }

        int encodedExtFirst = 0;
        for (int i = 1; i < encoded.length; i=i+2) {
            encodedExtFirst ^= encoded[i];
        }

        int decodeFirst = encodedAll ^ encodedExtFirst;

        int[] arr = new int[encoded.length + 1];
        arr[0] = decodeFirst;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = encoded[i-1] ^ arr[i-1];
        }
        return arr;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}