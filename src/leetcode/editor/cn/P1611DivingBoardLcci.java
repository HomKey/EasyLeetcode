//你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方
//法，生成跳水板所有可能的长度。 
// 返回的长度需要从小到大排列。 
// 示例： 
// 输入：
//shorter = 1
//longer = 2
//k = 3
//输出： {3,4,5,6}
// 
// 提示： 
// 
// 0 < shorter <= longer 
// 0 <= k <= 100000 
// 
// Related Topics 递归 记忆化


package leetcode.editor.cn;

import com.sun.org.apache.xpath.internal.operations.String;

//Java：跳水板
public class P1611DivingBoardLcci{
    public static void main(String[] args) {
        Solution solution = new P1611DivingBoardLcci().new Solution();
        // TO TEST
        solution.divingBoard(1,1,0);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k==0) return new int[0];
        if (shorter == longer) return new int[]{shorter*k};
        // shorter 0 ~ k
        int[] result = new int[k+1];
        for (int i = k; i >=0; --i) {
            result[k-i] = shorter * i + longer * (k-i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}