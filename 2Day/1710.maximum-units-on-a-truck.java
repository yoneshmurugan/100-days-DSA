/*
 * @lc app=leetcode id=1710 lang=java
 *
 * [1710] Maximum Units on a Truck
 *
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int units=0;
        for(int []box:boxTypes){
            if(truckSize>=box[0])
            {
                units+=box[0]*box[1];
                truckSize-=box[0];
            }
            else    
            {
                units+=truckSize*box[1];
                truckSize=0;
            }
            if(truckSize==0) break;
        } 
        return units;
        
    }
}
// @lc code=end
