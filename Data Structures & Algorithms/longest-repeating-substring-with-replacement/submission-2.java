class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0, newK = 0, maxFreq = 0;
        Map<Character, Integer>hash = new HashMap<>();
        // PriorityQueue<Pair<Integer, Character>>heap = PriorityQueue<>(comparator.reversOrder());
        int start = 0, end = 0;
        while(end < s.length()){
            System.out.println(start+" "+end);
            int currFreq = hash.getOrDefault(s.charAt(end),0)+1;
            hash.put(s.charAt(end), currFreq);
            maxFreq = Math.max(maxFreq, currFreq);
            System.out.println(hash);
            if(hash.size() == 1)newK = 0;
            else{
                newK = end-start+1 - maxFreq;
            }

            System.out.println(k + " " + newK);
            
            if(newK<=k)maxLength = Math.max(maxLength, end-start+1+k-newK);
            else{
                while(newK>k){
                    int temp = hash.get(s.charAt(start));
                    // if(temp==maxFreq){
                    //     maxFreq--;
                    // }
                    hash.put(s.charAt(start), temp-1);
                    if(temp == 1)hash.remove(s.charAt(start));
                    start++;
                    if(hash.size() == 1)newK = 0;
                    else{
                        newK = end-start+1 - maxFreq;
                    }
                }
            }
            end++;
            
        }
        return Math.min(maxLength,s.length());
    }
}
