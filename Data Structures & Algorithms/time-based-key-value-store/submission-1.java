class TimeMap {
    Map<String, List<Pair<String, Integer>>> hash;

    public TimeMap() {
        this.hash = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(this.hash.containsKey(key)){
            List<Pair<String, Integer>> pair = this.hash.get(key);
            pair.add(new Pair<>(value, timestamp));
        }else{
            List<Pair<String, Integer>> pair = new ArrayList<>();
            pair.add(new Pair<>(value,timestamp));
            this.hash.put(key, pair);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String,Integer>>pairs = this.hash.get(key);
        if(pairs == null)return "";
        int left = 0, right = pairs.size()-1;
        String result = "";
        while(left<=right){
            int mid = (left+right)/2;
            if(pairs.get(mid).getValue()<=timestamp){
                result = pairs.get(mid).getKey();
                left = mid+1;
            }else right = mid-1;
        }
        return result;
    }
}
