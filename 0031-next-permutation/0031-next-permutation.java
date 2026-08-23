class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        // Step 1: Find the pivot (first element from right that is smaller than the one after it)
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If a pivot exists, find the next largest element and swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        // Step 3: Reverse the tail elements to the right of the pivot
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}