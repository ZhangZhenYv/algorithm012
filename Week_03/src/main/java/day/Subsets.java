package api;

/**
 * 
 * 时间复杂度：\mathcal{O}(N \times 2^N)O(N×2
 * N
 *  )，生成所有子集，并复制到输出结果中。
 *
 * 空间复杂度：\mathcal{O}(N \times 2^N)O(N×2
 * N
 *  )，这是子集的数量。
 *
 * 对于给定的任意元素，它在子集中有两种情况，存在或者不存在（对应二进制中的 0 和 1）。因此，NN 个数字共有 2^N2
 * N
 *   个子集。
 *
 *
 */
public class Subsets {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> output = new ArrayList();
            output.add(new ArrayList<Integer>());

            for (int num : nums) {
                List<List<Integer>> newSubsets = new ArrayList();
                for (List<Integer> curr : output) {
                    newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
                }
                for (List<Integer> curr : newSubsets) {
                    output.add(curr);
                }
            }
            return output;
        }
    }


