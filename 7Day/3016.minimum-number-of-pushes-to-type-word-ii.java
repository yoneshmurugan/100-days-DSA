/*
 * @lc app=leetcode id=3016 lang=java
 *
 * [3016] Minimum Number of Pushes to Type Word II
 *
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
 */

// @lc code=start
import java.util.*;
class Solution {
    public int minimumPushes(String word) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0; i<word.length(); i++){
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i),0)+1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        int pushes = 0;
        for(int i=0; i<list.size(); i++){
            pushes += map.get(list.get(i)) * (i/8 + 1);
        }
        return pushes;


    }
}
// @lc code=end
