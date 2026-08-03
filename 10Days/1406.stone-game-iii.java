/*
 * @lc app=leetcode id=1406 lang=java
 *
 * [1406] Stone Game III
 *
 * https://leetcode.com/problems/stone-game-iii/
 */

// @lc code=start
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int[] dp = new int[n + 1];

        dp[n] = 0; 
        
        for (int i = n - 1; i >= 0; i--) {
            int maxDiff = Integer.MIN_VALUE;
            int stonesTakenScore = 0;
            
            for (int k = 1; k <= 3 && (i + k) <= n; k++) {
                stonesTakenScore += stoneValue[i + k - 1];
                
                maxDiff = Math.max(maxDiff, stonesTakenScore - dp[i + k]);
            }
            dp[i] = maxDiff;
        }
        
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
// @lc code=end
