import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred once
        prefixSumFreq.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if there is a prefix sum such that currentSum - k exists
            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }
            
            // Add or update the frequency of the current prefix sum in the map
            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}