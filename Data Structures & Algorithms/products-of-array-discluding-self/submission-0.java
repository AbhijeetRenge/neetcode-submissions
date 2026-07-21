class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n], rightProduct = new int[n];
        leftProduct[0] = 1;
        rightProduct[n-1] = 1;
        for(int i=1;i<n;i++){
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
            rightProduct[n-1-i] = rightProduct[n-i] * nums[n-i];
        }

        int[] result = new int[n];
        for(int i=0;i<n;i++){
            result[i] = leftProduct[i]*rightProduct[i];
        }
        return result;
    }
}  
