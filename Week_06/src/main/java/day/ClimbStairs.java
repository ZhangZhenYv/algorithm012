package api;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输出: false
 *
 */
public class ClimbStairs {

   public int climbStairs(int n) {
      double sqrt5 = Math.sqrt(5);
      double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
      return (int)(fibn / sqrt5);
   }



   }
