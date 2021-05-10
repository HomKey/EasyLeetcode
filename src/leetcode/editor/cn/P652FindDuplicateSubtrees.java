//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 265 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.bean.TreeNode;

import java.util.*;

//Java：寻找重复的子树
public class P652FindDuplicateSubtrees{
    public static void main(String[] args) {
        Solution solution = new P652FindDuplicateSubtrees().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 记录所有子树以及出现的次数
    Map<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getTreeStr(root);
        return res;
    }

    private String getTreeStr(TreeNode root){
        if (root == null ) return "#";
        String left = getTreeStr(root.left);
        String right = getTreeStr(root.right);
        String str = String.format("%s,%s,%s", left, right, root.val);
        Integer count = memo.getOrDefault(str, 0);
        if (count == 1){
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(str, count + 1);
        return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}