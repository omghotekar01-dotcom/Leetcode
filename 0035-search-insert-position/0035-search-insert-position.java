class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high = nums.length -1;
        if(nums[0]==target) return 0;
        while(low<high){
            int mid = low +((high-low)/2);
            if(nums[mid]==target) return mid;
            
            if(nums[mid]>target){
                high = mid -1 ;

            }else {
                low = mid+1;

            }
        }
        if (target>=nums[0]) 
        {
            if(target>nums[low]) return low+1;
            else  return low;
        }  
        else return low;
    }
}