class Solution {
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > majorityCount) {
                return nums[i];
            }
        }
        return -1; // Default return if no majority element is found
    }
}