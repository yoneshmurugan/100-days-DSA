/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 *
 * https://leetcode.com/problems/perfect-number/
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i =1;i<num;i++){
            if (num%i==0){
                sum+=i;
            }
        }
       if (sum==num){
        return true;
       }
       return false;
    }
}
// @lc code=end
