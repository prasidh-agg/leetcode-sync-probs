class Solution {
    public int[] replaceElements(int[] arr) {
       int n = arr.length;
       int greatest = -1;
       for(int i = n - 1; i >= 0; i--){
           if(arr[i] > greatest){
               int temp = greatest;
               greatest = arr[i];
               arr[i] = temp;
           }
           else{
               arr[i] = greatest;
           }
       }
       return arr;
    }
}
