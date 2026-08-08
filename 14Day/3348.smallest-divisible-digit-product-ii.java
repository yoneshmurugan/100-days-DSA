/*
 * @lc app=leetcode id=3348 lang=java
 *
 * [3348] Smallest Divisible Digit Product II
 *
 * https://leetcode.com/problems/smallest-divisible-digit-product-ii/
 */

// @lc code=start
class Solution {
    int[][] minD;
    
    public String smallestNumber(String num, long t) {
        minD = new int[50][35];
        for (int a = 0; a < 50; a++) {
            for (int b = 0; b < 35; b++) {
                int minLen = Integer.MAX_VALUE;
                for (int k = 0; k <= Math.min(a, b); k++) {
                    int remA = a - k;
                    int remB = b - k;
                    int len = k + (remA > 0 ? (remA + 2) / 3 : 0) + (remB > 0 ? (remB + 1) / 2 : 0);
                    minLen = Math.min(minLen, len);
                }
                minD[a][b] = minLen;
            }
        }
        
        int[] req = getFactors(t);
        if (req == null) return "-1";
        
        int n = num.length();
        int z = n;
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') {
                z = i;
                hasZero = true;
                break;
            }
        }
        
        int[][] prefFactors = new int[n + 1][4];
        for (int i = 0; i < n; i++) {
            int[] f = getFactorsForDigit(num.charAt(i) - '0');
            for (int k = 0; k < 4; k++) {
                prefFactors[i + 1][k] = prefFactors[i][k] + f[k];
            }
        }
        
        if (!hasZero) {
            boolean ok = true;
            for (int k = 0; k < 4; k++) {
                if (prefFactors[n][k] < req[k]) {
                    ok = false;
                    break;
                }
            }
            if (ok) return num;
        }
        
        for (int i = Math.min(n - 1, z); i >= 0; i--) {
            int[] curReq = subtract(req, prefFactors[i]);
            
            for (int d = num.charAt(i) - '0' + 1; d <= 9; d++) {
                int[] dF = getFactorsForDigit(d);
                int[] nextReq = subtract(curReq, dF);
                
                int rem = n - 1 - i;
                if (minD[nextReq[0]][nextReq[1]] + nextReq[2] + nextReq[3] <= rem) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num.substring(0, i));
                    sb.append(d);
                    
                    int[] buildReq = nextReq;
                    for (int j = i + 1; j < n; j++) {
                        int remPositions = n - 1 - j;
                        for (int c = 1; c <= 9; c++) {
                            int[] cF = getFactorsForDigit(c);
                            int[] tempReq = subtract(buildReq, cF);
                            if (minD[tempReq[0]][tempReq[1]] + tempReq[2] + tempReq[3] <= remPositions) {
                                sb.append(c);
                                buildReq = tempReq;
                                break;
                            }
                        }
                    }
                    return sb.toString();
                }
            }
        }
        
        int L = Math.max(n + 1, minD[req[0]][req[1]] + req[2] + req[3]);
        StringBuilder sb = new StringBuilder();
        int[] buildReq = req;
        for (int j = 0; j < L; j++) {
            int remPositions = L - 1 - j;
            for (int c = 1; c <= 9; c++) {
                int[] cF = getFactorsForDigit(c);
                int[] tempReq = subtract(buildReq, cF);
                if (minD[tempReq[0]][tempReq[1]] + tempReq[2] + tempReq[3] <= remPositions) {
                    sb.append(c);
                    buildReq = tempReq;
                    break;
                }
            }
        }
        return sb.toString();
    }
    
    int[] getFactors(long t) {
        int[] f = new int[4];
        while (t % 2 == 0) { f[0]++; t /= 2; }
        while (t % 3 == 0) { f[1]++; t /= 3; }
        while (t % 5 == 0) { f[2]++; t /= 5; }
        while (t % 7 == 0) { f[3]++; t /= 7; }
        if (t > 1) return null;
        return f;
    }
    
    int[] getFactorsForDigit(int d) {
        int[] f = new int[4];
        if (d == 0) return f;
        while (d % 2 == 0 && d > 1) { f[0]++; d /= 2; }
        while (d % 3 == 0 && d > 1) { f[1]++; d /= 3; }
        while (d % 5 == 0 && d > 1) { f[2]++; d /= 5; }
        while (d % 7 == 0 && d > 1) { f[3]++; d /= 7; }
        return f;
    }
    
    int[] subtract(int[] req, int[] f) {
        int[] res = new int[4];
        for (int k = 0; k < 4; k++) {
            res[k] = Math.max(0, req[k] - f[k]);
        }
        return res;
    }
}
// @lc code=end
