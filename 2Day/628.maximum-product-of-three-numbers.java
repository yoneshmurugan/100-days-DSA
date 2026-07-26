/*
 * @lc app=leetcode id=628 lang=java
 *
 * [628] Maximum Product of Three Numbers
 *
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // Option 1: Product of the 3 largest numbers
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        
        // Option 2: Product of 2 smallest (most negative) numbers * largest number
        int option2 = nums[0] * nums[1] * nums[n - 1];
        
        return Math.max(option1, option2);
    }
}
// @lc code=end
