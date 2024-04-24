class Solution {
    public int hIndex(int[] citations) {

        if(citations == null || citations.length == 0) return 0;
        //0,1,3,5,6
        //max possible h-index is number of papers, i.e. 5.
        //all values from 0 to 5 possible

        int n = citations.length;
        int[] count = new int[n + 1];

        for(int cite : citations){
            //case where if number of citations is greater than the number of total papers
            //just add it to the last paper..
            if(cite > n) count[n]++;

            else count[cite]++;
        }

        if(count[n] >= n) return n;
        for(int i = n - 1; i >= 0; i--){
            count[i] += count[i + 1];

            //atleast, thats why >=
            if(count[i] >= i) return i;
        }
        return 0;
    }
}


