class MinStack {

    List<Integer> vector;
    int size;
    Deque<Integer>minVal;

    public MinStack() {
        this.vector = new ArrayList<>();
        this.size = 0;
        this.minVal = new ArrayDeque<>();
    }
    
    public void push(int val) {
        vector.add(val);
        size++;
        if(minVal.isEmpty() || minVal.peek() >= val){
            minVal.push(val);
            // System.out.println(val);
        }
    }
    
    public void pop() {
        size--;
        // System.out.println(minVal.peek()+ " " + vector.get(size));
        if(minVal.peek().equals(vector.get(size))){
            // System.out.println(minVal.peek());
            minVal.pop();
        }
        vector.remove(size);
    }
    
    public int top() {
        return vector.get(size-1);
    }
    
    public int getMin() {
        return minVal.peek();
    }
}
