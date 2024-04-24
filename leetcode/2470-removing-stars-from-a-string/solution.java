class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*'){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        int len = st.size();
        char[] resArr = new char[len];
        for(int i = len - 1; i >= 0; i--){
            resArr[i] = st.pop();
        }
        return new String(resArr);
    }
}
