class Solution {
    
    public int numEquivDominoPairs(int[][] dominoes) {
        int pairs = 0;
        int[] count = new int[100];

        for(int[] d : dominoes){
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            int key = (a * 10) + b;

            pairs += count[key];
            count[key]++;
        }
        return pairs;
    }

}

