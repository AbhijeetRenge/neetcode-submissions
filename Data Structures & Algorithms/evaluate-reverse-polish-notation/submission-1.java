class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer>stack = new ArrayDeque<>();
        for(int i=0;i<tokens.length;i++){
            int a,b;
            if(tokens[i].equals("+")){
                a = stack.peek();
                stack.pop();
                b = stack.peek();
                stack.pop();
                stack.push(a+b);
            }else if(tokens[i].equals("-")){
                a = stack.peek();
                stack.pop();
                b = stack.peek();
                stack.pop();
                stack.push(b-a);
            }else if(tokens[i].equals("*")){
                a = stack.peek();
                stack.pop();
                b = stack.peek();
                stack.pop();
                stack.push(a*b);
            }else if(tokens[i].equals("/")){
                a = stack.peek();
                stack.pop();
                b = stack.peek();
                stack.pop();
                stack.push(b/a);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
