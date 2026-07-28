/*
 * @lc app=leetcode id=3517 lang=java
 *
 * [3517] Smallest Palindromic Rearrangement I
 *
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;
        
        char[] leftHalf = s.substring(0, halfLen).toCharArray();
        
        Arrays.sort(leftHalf);
        
        String left = new String(leftHalf);
        String right = new StringBuilder(left).reverse().toString();
        
        if (n % 2 != 0) {
            char mid = s.charAt(halfLen);
            return left + mid + right;
        } else {
            return left + right;
        }
    }
}

// @lc code=end
