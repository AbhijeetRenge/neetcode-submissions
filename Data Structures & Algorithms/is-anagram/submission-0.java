class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        Map<Character, Integer>hash1 = getMap(s);
        Map<Character, Integer>hash2 = getMap(t);


        for(Map.Entry<Character, Integer>entry : hash1.entrySet()){
            if(hash2.containsKey(entry.getKey()) && hash2.get(entry.getKey()).equals(entry.getValue()))continue;
            else return false;
        }
        return true;
        

    }

    public static Map<Character, Integer> getMap(String s){
        Map<Character, Integer>hash = new HashMap<>();
        for(int i =0 ; i<s.length(); i++){
            char c = s.charAt(i);
            if(hash.containsKey(c)){
                hash.put(c, hash.get(c)+1);
            }else{
                hash.put(c, 1);
            }
        }
        return hash;
    }
}
