/*
 * @lc app=leetcode id=1464 lang=java
 *
 * [1464] Maximum Product of Two Elements in an Array
 *
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 */

// @lc code=start
import java.util.Arrays;
class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int num1 = nums.length-1;
        int num2 = nums.length-2;
        return (nums[num1]-1)*(nums[num2]-1);
    }
}
// @lc code=end
