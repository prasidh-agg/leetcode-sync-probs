class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new LinkedList<>();
        int n = temperatures.length;
        int[] res = new int[temperatures.length];

        for(int i = n - 1; i >= 0; i--){

            //remove elements that are smaller than current temp from stack
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }

            //if stack empty means there are no bigger temps ahead.. let the answer just be default 0 in the array
            if(!st.isEmpty()){
                res[i] = st.peek() - i;
            }

            st.push(i);
        }
        System.gc();
        return res;
    }
}
