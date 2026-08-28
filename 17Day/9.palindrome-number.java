/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
        int y= x;
        while(x>0){
            rev = rev*10 + (x%10);
            x=x/10;
        }
        if(rev !=y){
            return false;
        }
        return true;    
    }
}
// @lc code=end
