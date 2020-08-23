package api;

/**
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 *
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 *
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 *
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * 示例：
 *
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 提示：
 *
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class SlidingPuzzle {

      public int slidingPuzzle(int[][] board) {
         int R = board.length, C = board[0].length;
         int sr = 0, sc = 0;
         search:
         for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
               if (board[sr][sc] == 0)
                  break search;

         int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
         Queue<Node> queue = new ArrayDeque();
         Node start = new Node(board, sr, sc, 0);
         queue.add(start);

         Set<String> seen = new HashSet();
         seen.add(start.boardstring);

         String target = Arrays.deepToString(new int[][]{{1,2,3}, {4,5,0}});

         while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.boardstring.equals(target))
               return node.depth;

            for (int[] di: directions) {
               int nei_r = di[0] + node.zero_r;
               int nei_c = di[1] + node.zero_c;

               if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                       nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                  continue;

               int[][] newboard = new int[R][C];
               int t = 0;
               for (int[] row: node.board)
                  newboard[t++] = row.clone();
               newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
               newboard[nei_r][nei_c] = 0;

               Node nei = new Node(newboard, nei_r, nei_c, node.depth+1);
               if (seen.contains(nei.boardstring))
                  continue;
               queue.add(nei);
               seen.add(nei.boardstring);
            }
         }

         return -1;
      }


   class Node {
      int[][] board;
      String boardstring;
      int zero_r;
      int zero_c;
      int depth;
      Node(int[][] B, int r, int c, int d) {
         board = B;
         boardstring = Arrays.deepToString(board);
         zero_r = r;
         zero_c = c;
         depth = d;
      }
   }

   }

