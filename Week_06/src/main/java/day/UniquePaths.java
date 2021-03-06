package api;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右

 *
 */
public class UniquePaths {


   public int uniquePaths(int m, int n) {
      /*int[] pre = new int[n];
      int[] cur = new int[n];
      Arrays.fill(pre, 1);
      Arrays.fill(cur,1);
      for (int i = 1; i < m;i++){
         for (int j = 1; j < n; j++){
            cur[j] = cur[j-1] + pre[j];
         }
         pre = cur.clone();
      }
      return pre[n-1];*/


      int[] cur = new int[n];
      Arrays.fill(cur,1);
      for (int i = 1; i < m;i++){
         for (int j = 1; j < n; j++){
            cur[j] += cur[j-1] ;
         }
      }
      return cur[n-1];



   }
