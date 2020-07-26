package api;

/**
 * 二叉树的最近公共祖先
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *

 */
public class LowestCommonAncestor {
    /*时间复杂度：O(N)O(N)，其中 NN 是二叉树的节点数。
    二叉树的所有节点有且只会被访问一次，因此时间复杂度为 O(N)O(N)。

    空间复杂度：O(N)O(N) ，其中 NN 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，
    二叉树最坏情况下为一条链，此时高度为 NN，因此空间复杂度为 O(N)O(N)。

*/
    private TreeNode ans;

        public Solution() {
            this.ans = null;
        }

        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return false;
            boolean lson = dfs(root.left, p, q);
            boolean rson = dfs(root.right, p, q);
            if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
                ans = root;
            }
            return lson || rson || (root.val == p.val || root.val == q.val);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.dfs(root, p, q);
            return this.ans;
        }
    }


