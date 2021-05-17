//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 149 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的堂兄弟节点
public class P993CousinsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P993CousinsInBinaryTree().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(4);
        root.right.left = null;
        root.right.right = new TreeNode(5);
        boolean cousins = solution.isCousins(root, 5, 4);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        boolean cousins = solution.isCousins(root, 4, 3);


        System.out.println(cousins);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        TreeNode xParent;
        TreeNode yParent;

        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) return false;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (queue.size() > 0) {
                xParent = null;
                yParent = null;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode parent = queue.poll();
                    if (parent == null) break;
                    if (parent.left != null) {
                        queue.add(parent.left);
                        if (parent.left.val == x) {
                            xParent = parent;
                            continue;
                        }
                        if (parent.left.val == y) {
                            yParent = parent;
                            continue;
                        }
                    }
                    if (parent.right != null) {
                        queue.add(parent.right);
                        if (parent.right.val == x) {
                            xParent = parent;
                            continue;
                        }
                        if (parent.right.val == y) {
                            yParent = parent;
                            continue;
                        }
                    }
                }
                // 当其中有1个!=null代表可以结束返回了
                if (xParent != null || yParent != null) {
                    return xParent != null && yParent != null && xParent != yParent;
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}