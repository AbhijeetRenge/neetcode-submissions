class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer>begin = new HashMap<>();
        Map<Integer,Integer>end = new HashMap<>();
        int longstSubsequence = 0;
        for(int i=0;i<nums.length;i++){
            if(begin.containsKey(nums[i]) || end.containsKey(nums[i])){
                continue;
            }
            // check in end array;
            int numTocheck;
            int left = nums[i], right = nums[i];
            int leftLength = 0, rightLength = 0;
            if(nums[i] != Integer.MIN_VALUE){
                numTocheck = nums[i]-1;
                if(end.containsKey(numTocheck)){
                    leftLength = end.get(numTocheck);
                    left = numTocheck - leftLength +1;
                    // if(begin.get(left)+left-1 >= nums[i])continue;
                }
            }
            
            if(nums[i] != Integer.MAX_VALUE){
                numTocheck = nums[i]+1;
                if(begin.containsKey(numTocheck)){
                    rightLength = begin.get(numTocheck);
                    right = numTocheck+rightLength-1;
                }
            }
            
            int currLength = leftLength+rightLength+1;
            begin.put(left, currLength);
            end.put(right, currLength);
            longstSubsequence = Math.max(longstSubsequence, currLength);
            // System.out.println("index "+i+" "+nums[i]);
            // System.out.println(begin);
            // System.out.println(end);
        }
        return longstSubsequence;
    }
}
