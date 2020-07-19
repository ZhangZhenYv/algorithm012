package api;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 复杂度分析
 *
 * 时间复杂度：O(N\log(k))O(Nlog(k))。Counter 方法的复杂度是 O(N)O(N)，
 * 建堆和输出的复杂度是 O(N \log(k))O(Nlog(k))。
 * 因此总复杂度为 O(N + N \log(k)) = O(N \log(k))O(N+Nlog(k))=O(Nlog(k))。
 * 空间复杂度：O(N)O(N)，存储哈希表的开销。
 * 注释
 *
 * 根据复杂度分析，方法对于小 k 的情况是很优的。但是如果 k 值很大，
 * 我们可以将算法改成删除频率最低的若干个元素。
 *
 */
public class TopKFrequent {
   public List<Integer> topKFrequent(int[] nums, int k) {
      // build hash map : character and how often it appears
      HashMap<Integer, Integer> count = new HashMap();
      for (int n: nums) {
         count.put(n, count.getOrDefault(n, 0) + 1);
      }

      // init heap 'the less frequent element first'
      PriorityQueue<Integer> heap =
              new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

      // keep k top frequent elements in the heap
      for (int n: count.keySet()) {
         heap.add(n);
         if (heap.size() > k)
            heap.poll();
      }

      // build output list
      List<Integer> top_k = new LinkedList();
      while (!heap.isEmpty())
         top_k.add(heap.poll());
      Collections.reverse(top_k);
      return top_k;
   }

}
