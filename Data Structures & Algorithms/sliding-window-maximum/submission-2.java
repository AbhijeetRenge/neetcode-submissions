class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer,Integer>hash = new HashMap<>();
        int start = 0, end = 0;
        int[] result = new int[nums.length-k+1];
        while(end < nums.length){
            // add in maxHeap
            // maintain frequency in map
            maxHeap.add(nums[end]);
            hash.put(nums[end], hash.getOrDefault(nums[end],0)+1);
            if(end-start+1 == k){
                result[end-k+1] = maxHeap.peek();
                hash.put(nums[start],(hash.get(nums[start])-1));
                if(hash.get(nums[start]) == 0){
                    hash.remove(nums[start]);
                }
                start++;
                while(!maxHeap.isEmpty() && !hash.containsKey(maxHeap.peek())){
                    maxHeap.poll();
                }
            }
            end++;
        }
        return result;
    }
}
