/*
 * @lc app=leetcode id=3310 lang=java
 *
 * [3310] Remove Methods From Project
 *
 * https://leetcode.com/problems/remove-methods-from-project/
 */

// @lc code=start
class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Build graph (Adjacency List)
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] inv : invocations) {
            adj[inv[0]].add(inv[1]);
        }
        
        // Step 1: Find all suspicious methods using DFS
        boolean[] isSuspicious = new boolean[n];
        dfs(k, adj, isSuspicious);
        
        // Step 2: Check if any non-suspicious method invokes a suspicious method
        boolean canRemove = true;
        for (int[] inv : invocations) {
            int caller = inv[0];
            int callee = inv[1];
            if (!isSuspicious[caller] && isSuspicious[callee]) {
                canRemove = false;
                break;
            }
        }
        
        // Step 3: Build the final list of remaining methods
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // If we cannot remove the buggy group, keep all methods.
            // If we can remove it, keep only the non-suspicious ones.
            if (!canRemove || !isSuspicious[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private void dfs(int node, List<Integer>[] adj, boolean[] isSuspicious) {
        isSuspicious[node] = true;
        for (int neighbor : adj[node]) {
            if (!isSuspicious[neighbor]) {
                dfs(neighbor, adj, isSuspicious);
            }
        }
    }
}
// @lc code=end
