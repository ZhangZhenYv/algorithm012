package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  LeetCode-1: 两数之和
 *
 * @author bingjie.chen
 * @date 2020/7/10
 */
public class TwoSum {

    //week01
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {

                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        //两数之和
        int [] nums2 = {2, 7, 11, 15};
        int target = 9;
        int [] kk= twoSum(nums2,target);
        for (int h=0;h<kk.length;h++){
            System.out.print(kk[h]+",");
        }

    }
    //第一种解题思路 暴力求解
    /**
     * 暴力求解
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     */
    public int[] twoSumByForce(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 使用hash求解
     */
    public int[] twoSumByHash(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hash.containsKey(diff)) {
                return new int[]{hash.get(diff), i};
            }
            hash.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }


}
