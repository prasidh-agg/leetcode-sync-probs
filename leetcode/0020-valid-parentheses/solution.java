class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                Character topOfStack = stack.peek();
                if (topOfStack == '{' && c == '}' || topOfStack == '(' && c == ')' || topOfStack == '[' && c == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
