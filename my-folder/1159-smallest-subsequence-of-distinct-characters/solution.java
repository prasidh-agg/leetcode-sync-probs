class Solution {
    public String smallestSubsequence(String s) {

        Stack<Character> st = new Stack<>();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];

        //build a frequency array
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        for(char c : s.toCharArray()){
            count[c - 'a']--;

            if(visited[c - 'a']) continue;

            while(!st.isEmpty() && st.peek() > c && count[st.peek() - 'a'] > 0){
                visited[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(c);  
            visited[c - 'a'] = true;
        }    

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char ch = st.pop();
            sb.insert(0, ch);
        }
        return sb.toString();
    }
}
