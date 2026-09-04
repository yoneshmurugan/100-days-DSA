/*
 * @lc app=leetcode id=3903 lang=java
 *
 * [3903] Smallest Stable Index I
 *
 * https://leetcode.com/problems/smallest-stable-index-i/
 */

// @lc code=start
import java.util.Arrays;
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int tno1=0;
        for(int i=0;i<nums.length;i++){
            int[] temp1=Arrays.copyOf(nums,i+1);
            int[] temp2=Arrays.copyOfRange(nums,i,nums.length);
            int min = Arrays.stream(temp2).min().getAsInt();
            int max = Arrays.stream(temp1).max().getAsInt();
            if (max-min <=k ){
                return i;
            }
        }return -1;

    }
}
// @lc code=end
