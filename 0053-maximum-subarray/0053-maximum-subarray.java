class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add the current number to the existing subarray 
            // or start a new subarray from the current number
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the global maximum sum if the current one is larger
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}