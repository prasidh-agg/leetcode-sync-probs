class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a : asteroids){
            while(!st.isEmpty() && a < 0 && st.peek() > 0){
                int sum = a + st.peek();
                if(sum < 0){
                    //go to left
                    st.pop();
                }
                else if(sum > 0){
                    //go to right, a is destroyed
                    a = 0; //to break out of while loop
                }
                else{
                    st.pop();
                    a = 0;
                }
            }
            if( a != 0){
                st.push(a);
            }
        }
        int size = st.size();
        int i = size - 1;
        int[] arr = new int[size];
        while(!st.isEmpty()){
            arr[i--] = st.pop();
        }
        return arr;
    }
}
