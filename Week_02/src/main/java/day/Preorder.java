package api;

/**
 *
 *N叉树的前序遍历
 * @author bingjie.chen
 * @date 2020/7/8
 */
public class Preorder {
   /*时间复杂度：时间复杂度：O(M)O(M)，其中 MM 是 N 叉树中的节点个数。每个节点只会入栈和出栈各一次。

   空间复杂度：O(M)O(M)。在最坏的情况下，这棵 N 叉树只有 2 层，所有第 2 层的节点都是根节点的孩子。
   将根节点推出栈后，需要将这些节点都放入栈，共有 M - 1M−1 个节点，因此栈的大小为 O(M)O(M)。*/


   public List<Integer> preorder(Node root) {
      LinkedList<Node> stack = new LinkedList<>();
      LinkedList<Integer> output = new LinkedList<>();
      if (root == null) {
         return output;
      }

      stack.add(root);
      while (!stack.isEmpty()) {
         Node node = stack.pollLast();
         output.add(node.val);
         Collections.reverse(node.children);
         for (Node item : node.children) {
            stack.add(item);
         }
      }
      return output;
   }


}
