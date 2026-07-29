/*
 * @lc app=leetcode id=3518 lang=java
 *
 * [3518] Smallest Palindromic Rearrangement II
 *
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int halfLen = n / 2;
        int[] freq = new int[26];
        String mid = "";

        for (int i = 0; i < 26; i++) {
            freq[i] = count[i] / 2;
            if (count[i] % 2 != 0) {
                mid = String.valueOf((char) ('a' + i));
            }
        }

        long totalPerms = countPermutations(freq, k);
        if (totalPerms < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    freq[i]--;
                    long ways = countPermutations(freq, k);
                    if (ways >= k) {
                        left.append((char) ('a' + i));
                        break;
                    } else {
                        k -= ways;
                        freq[i]++; // Backtrack
                    }
                }
            }
        }

        String leftStr = left.toString();
        String rightStr = new StringBuilder(leftStr).reverse().toString();

        return leftStr + mid + rightStr;
    }

    private long countPermutations(int[] freq, int maxK) {
        int total = 0;
        for (int f : freq) total += f;

        long res = 1;
        int currentLen = total;

        for (int f : freq) {
            if (f <= 0) continue;
            res = combine(res, nCr(currentLen, f, maxK), maxK);
            currentLen -= f;
            if (res >= maxK) return maxK;
        }

        return res;
    }

    private long nCr(int n, int r, int maxK) {
        if (r > n - r) r = n - r;
        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans >= maxK) return maxK;
        }
        return ans;
    }

    private long combine(long a, long b, int maxK) {
        if (a == 0 || b == 0) return 0;
        if (a >= (maxK + b - 1) / b) return maxK;
        return a * b;
    }
}
// @lc code=end
