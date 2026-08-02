/*
 * @lc app=leetcode id=877 lang=java
 *
 * [877] Stone Game
 *
 * https://leetcode.com/problems/stone-game/
 */

// @lc code=start
class Solution {
    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        int[][] diff = new int[n][n];
        for (int i = 0; i < n; i++) {
            diff[i][i] = piles[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                diff[i][j] = Math.max(piles[i] - diff[i + 1][j], piles[j] - diff[i][j - 1]);
            }
        }
        return diff[0][n - 1] > 0;
    }
}
// @lc code=end
