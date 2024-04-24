class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while(top <= bottom && left <= right){
            //traverse left to right
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
                top += 1;

            //traverse right to bottom
            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
                right -= 1;

            //traverse right to left
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
                bottom -= 1;
            }
            

            //traverse bottom to top
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                left += 1;
            }

        }
        return res;
    }
}
