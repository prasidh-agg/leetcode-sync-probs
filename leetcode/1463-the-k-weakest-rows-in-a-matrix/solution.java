class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[mat.length];
        int[] res = new int[k];
        for(int i = 0; i < mat.length; i++){
            int count = count1s(mat[i]);
            arr[i] = (count * 1000) + i;
        }

        Arrays.sort(arr);
        for(int i = 0; i < k; i++){
            res[i] = arr[i] % 1000;
        }
        return res;
    }
    public int count1s(int[] row){
        int count = 0;
        int i = 0;
        while(i < row.length && row[i] != 0){
            count++;
            i++;
        }
        return count;
    }
}
