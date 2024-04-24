class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length < 2) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++){
            int[] left = intervals[i-1];
            int[] right = intervals[i];
            if(right[0] > left[1]){
                result.add(left);
            }
            else{
                right[0] = left[0];
                if(left[1] > right[1]){
                    right[1] = left[1];
                }
            }
            if(i == intervals.length - 1){
                result.add(right);
            }
        }

        int[][] array = new int[result.size()][2];
        result.toArray(array);
        return array;

    }
}
