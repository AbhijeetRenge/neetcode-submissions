class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minK = 1, maxK = Integer.MIN_VALUE;

        for(int i=0;i<piles.length;i++){
            maxK = Math.max(piles[i], maxK);
        }
        int result = Integer.MAX_VALUE;
        while(minK <= maxK){
            int rate = (minK+maxK)/2;
            int k = getHours(piles, rate);
            System.out.println("rate "+rate+" k "+k);
            if(k <= h){
                result = Math.min(result, rate);
                maxK = rate-1;
            }else minK = rate+1;

        }
        return result;
    }

    public static int getHours(int[] piles, int h){
        int tot = 0;
        for(int i=0;i<piles.length;i++){
            tot+=piles[i]/h;
            if(piles[i]%h >0)tot++;
        }
        return tot;
    }
}
