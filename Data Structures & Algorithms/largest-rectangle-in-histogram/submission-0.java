class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer>leftMin = new ArrayDeque<>();
        Deque<Integer>rightMin = new ArrayDeque<>();
        int[] left = new int [heights.length], right = new int[heights.length];
        int n = heights.length;

        for(int i=0;i<heights.length;i++){
            while(!leftMin.isEmpty() && heights[leftMin.peek()] >= heights[i] )leftMin.pop();
            if(leftMin.isEmpty())left[i] = -1;
            else left[i] = leftMin.peek();
            leftMin.push(i);

            while(!rightMin.isEmpty() && heights[rightMin.peek()] >= heights[n-1-i] )rightMin.pop();
            if(rightMin.isEmpty())right[n-1-i] = heights.length;
            else right[n-1-i] = rightMin.peek();
            rightMin.push(n-1-i);
        }

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        int area = 0;
        for(int i=0;i<heights.length;i++){
            int leftIndex = left[i];
            int rightIndex = right[i];

            int currArea = (heights[i])*(rightIndex-leftIndex-1);
            area = Math.max(area, currArea);
        }
        return area;
    }
}
