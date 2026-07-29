class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int leftSize = totalSize/2, rightSize = leftSize;
        if(totalSize % 2 == 1)leftSize++;

        PriorityQueue<Integer>right = new PriorityQueue<>(), left = new PriorityQueue<>(Comparator.reverseOrder());
        int maxIndex = Math.max(nums1.length, nums2.length);
        for(int i = 0; i<maxIndex; i++){
            if (i<nums1.length){
                if(left.size()<leftSize){
                    left.add(nums1[i]);
                }else {
                    if(left.peek() > nums1[i]){
                        int temp = left.poll();
                        left.add(nums1[i]);
                        right.add(temp);
                    }else{
                        right.add(nums1[i]);
                    }
                }
            }
            if (i<nums2.length){
                if(left.size()<leftSize){
                    left.add(nums2[i]);
                }else {
                    if(left.peek() > nums2[i]){
                        int temp = left.poll();
                        left.add(nums2[i]);
                        right.add(temp);
                    }else{
                        right.add(nums2[i]);
                    }
                }
            }
        }

        if(leftSize == rightSize){
            return (double)(left.peek()+right.peek())/2;
        }
        else return left.peek();
    }
}
