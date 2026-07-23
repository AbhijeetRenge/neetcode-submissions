class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1;
        int maxWater = 0;
        while(left<right){
            maxWater = Math.max(Math.min(heights[left], heights[right])*(right-left),maxWater);
            if(heights[left] < heights[right])left++;
            else right--;
        }
        return maxWater;
    }
}
