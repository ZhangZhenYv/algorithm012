package api;

/**
 * 二分查找
 */
public class BinarySearch {
   // Java
   public int binarySearch(int[] array, int target) {
      int left = 0, right = array.length - 1, mid;
      while (left <= right) {
         mid = (right - left) / 2 + left;

         if (array[mid] == target) {
            return mid;
         } else if (array[mid] > target) {
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }

      return -1;
   }
}
