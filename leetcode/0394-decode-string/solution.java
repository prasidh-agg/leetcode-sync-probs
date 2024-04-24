class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack();

        for(char c : s.toCharArray()){
            if(c  != ']'){
                st.push(c);
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && Character.isLetter(st.peek())){
                    sb.insert(0, st.pop());
                }
                String newStr = sb.toString();

                //pop the opening brace
                st.pop();

                sb = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    sb.insert(0,st.pop());
                }
                int count = Integer.parseInt(sb.toString());
                while(count > 0){
                    for(char ch : newStr.toCharArray()){
                        st.push(ch);
                    }
                    count--;
                }
            }
        }

        StringBuilder resString = new StringBuilder();
        while(!st.isEmpty()){
            resString.insert(0,st.pop());
        }
        return resString.toString();
    }
}
