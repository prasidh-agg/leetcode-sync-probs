class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = flowers.length;
        int n = people.length;
        int[] result = new int[n];

        int[] startTimes = new int[m];        
        int[] endTimes = new int[m];
        for(int i = 0; i < m; i++){
            startTimes[i] = flowers[i][0];
            endTimes[i] = flowers[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        for(int i = 0; i < n; i++){
            int bloomed = binarySearchUpperBound(startTimes, people[i]);
            int died = binarySearchLowerBound(endTimes, people[i]);
            result[i] = bloomed - died;
        }
        return result;

    }
    private int binarySearchLowerBound(int[] arr, int target){
        int l = 0, r = arr.length - 1;
        int result = arr.length;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] < target){
                l = mid + 1;
            }
            else{
                result = mid;
                r = mid - 1;
            }
        }
        return result;

    }

    private int binarySearchUpperBound(int[] arr, int target){
        int l = 0, r = arr.length - 1;
        int result = arr.length;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] > target){
                result = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return result;
    }
}
