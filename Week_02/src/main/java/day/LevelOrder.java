package api;

/**
 * 使用add first或者add last改写deque的API
 *
 * @author bingjie.chen
 * @date 2020/7/18
 */
public class LevelOrder {
  /* 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
  * N叉树的层序遍历*/
   /*方法一：利用队列实现广度优先搜索
   我们要构造一个 sub-lists 列表，其中每个 sub-list 是树中一行的值。行应该按从上到下的顺序排列。

   因为我们从根节点开始遍历树，然后向下搜索最接近根节点的节点，这是广度优先搜索。我们使用队列来进行广度优先搜索，
   队列具有先进先出的特性。

   在这里使用栈是错误的选择，栈应用于深度优先搜索。

   让我们在树上使用基于队列的遍历算法，看看它的作用。这是你应该记住的一个基本算法。*/


           /* List<Integer> values = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
               Node nextNode = queue.remove();
               values.add(nextNode.val);
               for (Node child : nextNode.children) {
                  queue.add(child);
               }
            }
            */


         public List<List<Integer>> levelOrder2(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
               List<Integer> level = new ArrayList<>();
               int size = queue.size();
               for (int i = 0; i < size; i++) {
                  Node node = queue.poll();
                  level.add(node.val);
                  queue.addAll(node.children);
               }
               result.add(level);
            }
            return result;
         }
         public List<List<Integer>> levelOrder3(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;

            List<Node> previousLayer = Arrays.asList(root);

            while (!previousLayer.isEmpty()) {
               List<Node> currentLayer = new ArrayList<>();
               List<Integer> previousVals = new ArrayList<>();
               for (Node node : previousLayer) {
                  previousVals.add(node.val);
                  currentLayer.addAll(node.children);
               }
               result.add(previousVals);
               previousLayer = currentLayer;
            }

            return result;
         }




}
