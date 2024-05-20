class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0, high = len - 1;

        while(low <= high){
            int mid = high + (low - high) / 2;
            if(citations[mid] == len - mid) return len - mid;

            else if(citations[mid] < len - mid){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return len - low;
    }
}
