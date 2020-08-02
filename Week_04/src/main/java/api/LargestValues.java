package api;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 *
 */
public class LargestValues {
   /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) { val = x; }
    * }
    */

      private Map<Integer, List<Integer>> m = new TreeMap<>();

      /** BFS Solution  **/
      public List<Integer> largestValues2(TreeNode root) { // iterative

         List<Integer> result = new ArrayList<>();
         if (root == null) return result;

         Queue<TreeNode> q = new LinkedList<>();
         q.offer(root);

         while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE; // 每一层节点元素的最大值 (maximum)
            for (int size = q.size(); size > 0; --size) { // 练习逆向思维 ...
               TreeNode cur = q.poll();
               max = Math.max(max, cur.val);
               if (cur.left != null) q.offer(cur.left);
               if (cur.right != null) q.offer(cur.right);
            }
            result.add(max);
         }

         return result;
      }

      private void preorderTraversal(TreeNode r, int d) {
         if (r == null) return;
         if (!m.containsKey(d))
            m.put(d, new ArrayList<>());
         m.get(d).add(r.val);
         preorderTraversal(r.left, d + 1);
         preorderTraversal(r.right, d + 1);
      }

      /** DFS Solution **/
      public List<Integer> largestValues(TreeNode root) { // recursive
         // generate data information
         preorderTraversal(root, 0);

         List<Integer> result = new ArrayList<>();
         for (List<Integer> row : m.values())
            result.add(Collections.max(row));

         return result;
      }
   }


