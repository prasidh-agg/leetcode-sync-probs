class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k) return "0";

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            while(k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        //in case when all digits are increasing, we never get the chance to delete digits. SO just pop from top until we make k 0
        while(k > 0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder("");
        //first add the elements from the stack
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        //now add the remaining elements.. from index all the way to the h
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // System.out.println("Answer is: " + ans);
        return sb.toString();
    }
}
