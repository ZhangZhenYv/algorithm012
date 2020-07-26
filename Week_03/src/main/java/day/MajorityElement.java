package api;

/**
 *示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

   private Map<Integer, Integer> countNums(int[] nums) {
      Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
      for (int num : nums) {
         if (!counts.containsKey(num)) {
            counts.put(num, 1);
         }
         else {
            counts.put(num, counts.get(num)+1);
         }
      }
      return counts;
   }

   public int majorityElement(int[] nums) {
      Map<Integer, Integer> counts = countNums(nums);

      Map.Entry<Integer, Integer> majorityEntry = null;
      for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
         if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
            majorityEntry = entry;
         }
      }

      return majorityEntry.getKey();
   }
}


