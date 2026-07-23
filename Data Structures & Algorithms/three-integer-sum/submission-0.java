class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>>result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int left = i+1, right = nums.length-1;
            while(left<right){
                int value = nums[i]+nums[left]+nums[right];
                if(value == 0){
                    List<Integer>innerList = new ArrayList<>(List.of(nums[i],nums[left],nums[right]));
                    result.add(innerList);
                    while(left < right && nums[left]==nums[++left]);
                    while(right > left && nums[right]==nums[--right]);
                }else if(value < 0)left++;
                else right--;
            }
        }
        return result;
    }
}
