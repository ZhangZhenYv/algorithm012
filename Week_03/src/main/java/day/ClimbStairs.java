package api;

/**
 * 
 * 爬楼梯
 *
 *
 */
public class ClimbStairs {
    /*时间复杂度：O(\log n)O(logn)，pow 方法将会用去 O(\log n)O(logn) 的时间。
    空间复杂度：O(1)O(1)。
    总结*/
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }
}
