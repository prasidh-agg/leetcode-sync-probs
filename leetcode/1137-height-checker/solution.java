class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] count = new int[101];

        //build map for how many times does a height exist
        for(int height : heights){
            count[height]++;
        }
        int ans = 0;
        int expectedHeight = 1;

        for(int i = 0; i < heights.length; i++){

            //this means that, traverse the count array.. and find the next non zero height
            while(count[expectedHeight] == 0) expectedHeight++;

            //if current height does equal the expected height.. it means its in the wrong place
            if(heights[i] != expectedHeight){
                ans++;
            }
            count[expectedHeight]--;
        }

        return ans;
    }
}
