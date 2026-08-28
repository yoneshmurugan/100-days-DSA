/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long rev = 0;
        
        while (x != 0) {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }
        
        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }
        
        return (int) rev;
    }
}
// @lc code=end
