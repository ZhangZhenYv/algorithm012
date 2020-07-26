package api;

/**
 * 全排列
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permute {

      public void backtrack(int n,
                            ArrayList<Integer> output,
                            List<List<Integer>> res,
                            int first) {
         // 所有数都填完了
         if (first == n)
            res.add(new ArrayList<Integer>(output));
         for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
         }
      }

      public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> res = new LinkedList();

         ArrayList<Integer> output = new ArrayList<Integer>();
         for (int num : nums)
            output.add(num);

         int n = nums.length;
         backtrack(n, output, res, 0);
         return res;
      }
   }


