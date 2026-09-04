/*
 * @lc app=leetcode id=1837 lang=java
 *
 * [1837] Sum of Digits in Base K
 *
 * https://leetcode.com/problems/sum-of-digits-in-base-k/
 */

// @lc code=start
class Solution {
    public int sumBase(int n, int k) {
        int conv=0;
        while(n>0){
            conv=(conv*10)+(n%k);
            n=n/k;
        }
        int count=0;
        while (conv>0){
            int digit= conv%10;
            conv/=10;
            count+=digit;
        }
        return count;
        
    }
}
// @lc code=end
