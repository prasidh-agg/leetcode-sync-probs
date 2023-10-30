class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            arr[i] += count1Bits(arr[i]) * 100001;
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            arr[i] = arr[i] % 100001;
        }
        return arr;


    }
    public int count1Bits(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
