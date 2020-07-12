package leetcode;

/**
 * LeetCode-88:
 * 合并两个有序数组
 *
 * @author bingjie.chen
 * @date 2020/7/8
 */
public class MergeTwoArray {

    //week01
    //合并两个有序数组
    //时间复杂度 : O(n + m)O(n+m)。
    //空间复杂度 : O(1)O(1)。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 从尾部进行遍历,添加到长数组的尾部
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums1 第一个数组
     * @param m     第一个数组的非零长度
     * @param nums2 第二个数组
     * @param n     第二个数组的非零长度
     */
    public void mergeTwoArrayFromTail(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1, len2 = n - 1, len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        //最后把nums2中剩余的copy到nums1中
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
    /**
     * 从尾部进行遍历,添加到长数组的尾部
     * note:最后不需要进行copy
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums1 第一个数组
     * @param m     第一个数组的非零长度
     * @param nums2 第二个数组
     * @param n     第二个数组的非零长度
     */
    public void mergeTwoArrayNoCopy(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            nums1[m + n -1] = (m == 0 || nums2[n - 1] > nums1[m - 1]) ? nums2[--n] : nums1[--m];
        }
    }
}
