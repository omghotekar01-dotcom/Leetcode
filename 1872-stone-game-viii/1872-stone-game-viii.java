class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // Compute the prefix sum of the last element, which serves as the base case (dp[n-1] = s[n-1])
        int currentMax = 0;
        for (int stone : stones) {
            currentMax += stone;
        }
        
        // Iterate backwards from n - 2 down to 1
        for (int i = n - 2; i >= 1; i--) {
            currentMax += stones[i]; // This builds the prefix sum s[i] on the fly
            currentMax = Math.max(currentMax, currentMax - (currentMax - stones[i])); // Wait, let's use the clean suffix-maximum logic below:
        }
        
        // Let's rewrite cleanly with explicit prefix sum calculation:
        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }
        
        int res = prefixSum[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            res = Math.max(res, prefixSum[i] - res);
        }
        
        return res;
    }
}