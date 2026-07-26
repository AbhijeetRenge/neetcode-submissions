class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair<Integer, Integer>>ps = new ArrayList<>();
        for(int i=0; i<speed.length;i++){
            ps.add(new Pair<>(position[i], speed[i]));
        }

        // Collections.sort(ps, Collections.reverseOrder());
        ps.sort(Comparator.comparing(Pair::getKey, Collections.reverseOrder()));

        System.out.println(ps);

        Deque<Double>stack = new ArrayDeque<>();
        for(int i=0;i<ps.size();i++){
            double time = (double)(target - ps.get(i).getKey())/ps.get(i).getValue();
            System.out.println(i + " "+time);
            if(stack.isEmpty() || Double.compare(stack.peek(), time) < 0){
                stack.push(time);
            }
        }
        System.out.println(stack);
        return stack.size();
    }
}
