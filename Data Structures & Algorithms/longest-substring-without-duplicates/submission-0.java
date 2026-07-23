class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>hash = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;
        while(right < s.length()){
            if(hash.contains(s.charAt(right))){
                maxLength = Math.max(maxLength, right-left);
                while(s.charAt(left) != s.charAt(right)){
                    hash.remove(s.charAt(left++));
                }
                left++;
            }else{
                hash.add(s.charAt(right));
            }
            right++;
        }
        return Math.max(maxLength, right-left);
    }
}
