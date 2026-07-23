class Solution {
    public int trap(int[] height) {
        // Stack<Integer>left = new Stack<>(), right = new Stack<>();
        // List<Integer>leftMax = new ArrayList<>(), rightMax = new ArrayList<>();
        int n = height.length;
        int [] leftMax = new int [n], rightMax = new int[n];
        leftMax[0] = -1;
        rightMax[n-1] = -1;
        // left.push(height[0]);
        // right.push(height[n-1]);
        int left = height[0], right = height[n-1];
        for(int i=1;i<n;i++){
            if(left >= height[i])leftMax[i] = left;
            else{
                left = height[i];
                leftMax[i] = left;
            }
            if(right >= height[n-i-1])rightMax[n-i-1] = right;
            else{
                right = height[n-i-1];
                rightMax[n-i-1] = right;
            }
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        int totalWater = 0;
        for(int i=1;i<n-1;i++){
            if(leftMax[i] == -1 || rightMax[i] == -1)continue;
            totalWater += Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return totalWater;
    }
}
