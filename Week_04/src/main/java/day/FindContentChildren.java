package api;

/**
 *
 输入: [1,2], [1,2,3]

 输出: 2
 *
 *分发饼干
 */
public class FindContentChildren {
//贪心算法
    public int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

}