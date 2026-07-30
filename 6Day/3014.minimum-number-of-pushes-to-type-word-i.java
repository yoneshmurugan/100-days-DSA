/*
 * @lc app=leetcode id=3014 lang=java
 *
 * [3014] Minimum Number of Pushes to Type Word I
 *
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
 */

// @lc code=start
class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int totalPushes = 0;
        int pushesPerKey = 1;
        
        while (n > 0) {
            if (n >= 8) {
                totalPushes += 8 * pushesPerKey;
                n -= 8;
            } else {
                totalPushes += n * pushesPerKey;
                n = 0;
            }
            pushesPerKey++;
        }
        
        return totalPushes;
    }
}
// @lc code=end
