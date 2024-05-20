class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        for(int citation : citations){
            //if the citations are greater than number of papers, just add it to the last.
            if(citation >= n) count[n]++;

            else count[citation]++;
        }
        if(count[n] >= n) return n;

        for(int i = n - 1; i >= 0; i--){
            count[i] += count[i + 1];
            if(count[i] >= i) return i;
        }
        return 0;
    }
}
