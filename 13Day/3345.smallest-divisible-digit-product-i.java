/*
 * @lc app=leetcode id=3345 lang=java
 *
 * [3345] Smallest Divisible Digit Product I
 *
 * https://leetcode.com/problems/smallest-divisible-digit-product-i/
 */

// @lc code=start
class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int prod = 1;
            int temp = n;
            while (temp > 0) {
                prod *= temp % 10;
                temp /= 10;
            }
            
            if (prod % t == 0) {
                return n;
            }
            n++;
        }
    }
}
// @lc code=end
