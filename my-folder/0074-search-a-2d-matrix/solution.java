class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        // if(target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        for(int i = 0; i < m; i++){
            if(target >= matrix[i][0] && target <= matrix[i][n - 1]){
                //perform binary search on this array
                return binSearch(matrix[i], target);
            }
        } 
        return false;
    }
    private static boolean binSearch(int[] arr, int target){
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target) return true;
            else if(arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
