//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 496 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.bean.TreeNode;

//Java：从中序与后序遍历序列构造二叉树
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // TO TEST
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postoreder, int postStart, int postEnd) {
            if (inStart > inEnd) return null;
            int rootVal = postoreder[postEnd];
            int index = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (rootVal == inorder[i]) {
                    index = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(rootVal);
            int leftSize = index - inStart;
            root.left = build(inorder, inStart, index - 1, postoreder, postStart, postStart + leftSize - 1);
            root.right = build(inorder, index + 1, inEnd, postoreder, postStart + leftSize, postEnd - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}