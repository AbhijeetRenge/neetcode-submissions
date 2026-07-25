class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer>permutation = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            permutation.put(s1.charAt(i), permutation.getOrDefault(s1.charAt(i),0)+1);
        }
        Map<Character,Integer>windowMap = new HashMap<>();
        int start = 0;
        for(int end = 0;end<s2.length();end++){
            
            // System.out.println(start+" "+end);
            if(permutation.containsKey(s2.charAt(end))){
                int freq = windowMap.getOrDefault(s2.charAt(end),0)+1;
                int expectedFreq = permutation.get(s2.charAt(end));
                // System.out.println(freq+" "+expectedFreq);
                if(expectedFreq >= freq){
                    windowMap.put(s2.charAt(end),freq);
                    if(end-start+1 == s1.length())return true;
                }else{
                    while(freq > expectedFreq){
                        windowMap.put(s2.charAt(start), windowMap.get(s2.charAt(start))-1);
                        if(windowMap.get(s2.charAt(start)) == 0){
                            windowMap.remove(s2.charAt(start));
                        }
                        if(s2.charAt(start) == s2.charAt(end))freq--;
                        start++;
                        // end--;
                    }
                    end--;
                }
            }else{
                windowMap.clear();
                start = end+1;
            }
            // System.out.println(permutation);
            // System.out.println(windowMap);
        }
        return false;
    }
}
