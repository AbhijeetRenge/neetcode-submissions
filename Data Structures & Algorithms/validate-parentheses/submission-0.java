class Solution {
    public boolean isValid(String s) {
        Deque<Character>stack = new ArrayDeque<>();
        for (int i=0;i<s.length();i++){
            char currChar = s.charAt(i);
            if( currChar == '(' || currChar == '{' || currChar == '[' )
            stack.push(currChar);
            else{
                if(stack.isEmpty())return false;
                if(currChar == ')' && stack.peek() == '(')stack.pop();
                else if(currChar == '}' && stack.peek() == '{')stack.pop();
                else if(currChar == ']' && stack.peek() == '[')stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
