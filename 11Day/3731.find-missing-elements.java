/*
 * @lc app=leetcode id=3731 lang=java
 *
 * [3731] Find Missing Elements
 *
 * https://leetcode.com/problems/find-missing-elements/
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int num1 = nums[0]; 
        for (int i = 0; i < nums.length; i++) {
            int num2 = nums[i];
            while (num1 < num2) {
                result.add(num1);
                num1++;
            }
            num1 = num2 + 1; 
        }
        return result;
    }
}

// @lc code=end
