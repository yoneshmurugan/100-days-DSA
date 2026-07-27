/*
 * @lc app=leetcode id=2357 lang=java
 *
 * [2357] Make Array Zero by Subtracting Equal Amounts
 *
 * https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        while (true) {
            int x = 0;
            for (int num : nums) {
                if (num > 0) {
                    x = num;
                    break;
                }
            }
            if (x == 0) {
                break;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i] -= x;
                }
            }

            count++;
        }

        return count;
    }
}
// @lc code=end
