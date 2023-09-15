class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        int prev = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= prev){
                //it means they don't overlap
                prev = intervals[i][1];
            }
            else{
                prev = Math.min(prev, intervals[i][1]);
                ans += 1;
            }
        }
        return ans;
    }
}
