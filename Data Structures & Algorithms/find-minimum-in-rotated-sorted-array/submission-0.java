class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            if(left == right){
                return nums[left];
            }
            int mid = (left+right)/2;
            if(mid == left){
                return Math.min(nums[left], nums[right]);
            }
            if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1])return nums[mid];
            else if(nums[mid] > nums[right])left = mid+1;
            else right = mid - 1;
        }
        return 0;
    }
}
