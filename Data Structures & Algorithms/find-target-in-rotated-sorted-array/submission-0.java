class Solution {
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length-1;
        int startIndex = 0;
        while(left<=right){
            if(left == right){
                startIndex = left;
                break;
            }
            if(left + 1 == right){
                startIndex = left;
                if(nums[right] < nums[left])startIndex = right;
                break;
            }

            int mid = (left+right)/2;
            if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                startIndex = mid;
                break;
            }else if(nums[mid] > nums[right])left = mid+1;
            else right = mid - 1;
        }
        int result = -1;
        result = bSearch(nums, target, 0, startIndex-1);
        if(result != -1)return result;
        return bSearch(nums, target, startIndex, nums.length-1);

    }

    public static int bSearch(int[] nums, int t, int left, int right) {
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == t)return mid;
            else if(nums[mid]<t)left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
