package api;

/**
 *二叉树的中序遍历
 * @author bingjie.chen
 * @date 2020/7/18
 */
public class InorderTraversal {
   /*时间复杂度：O(n)O(n)。递归函数 T(n) = 2 \cdot T(n/2)+1T(n)=2⋅T(n/2)+1。
   空间复杂度：最坏情况下需要空间O(n)O(n)，平均情况为O(\log n)O(logn)。
   二叉树的中序遍历*/


   public List < Integer > inorderTraversal(TreeNode root) {
      List < Integer > res = new ArrayList < > ();
      helper(root, res);
      return res;
   }

   public void helper(TreeNode root, List < Integer > res) {
      if (root != null) {
         if (root.left != null) {
            helper(root.left, res);
         }
         res.add(root.val);
         if (root.right != null) {
            helper(root.right, res);
         }
      }
   }

   /*时间复杂度：O(n)O(n)。

   空间复杂度：O(n)O(n)。*/
   public List < Integer > inorderTraversal2(TreeNode root) {
      List < Integer > res = new ArrayList < > ();
      Stack < TreeNode > stack = new Stack < > ();
      TreeNode curr = root;
      while (curr != null || !stack.isEmpty()) {
         while (curr != null) {
            stack.push(curr);
            curr = curr.left;
         }
         curr = stack.pop();
         res.add(curr.val);
         curr = curr.right;
      }
      return res;
   }



}
