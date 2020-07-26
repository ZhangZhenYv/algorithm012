package api;

/*给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

        示例:
组合
        输入: n = 4, k = 2
        输出:
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]*/

public class Combine {
   List<List<Integer>> output = new LinkedList();
   int n;
   int k;

   public void backtrack(int first, LinkedList<Integer> curr) {
      // if the combination is done
      if (curr.size() == k)
         output.add(new LinkedList(curr));

      for (int i = first; i < n + 1; ++i) {
         // add i into the current combination
         curr.add(i);
         // use next integers to complete the combination
         backtrack(i + 1, curr);
         // backtrack
         curr.removeLast();
      }
   }
}