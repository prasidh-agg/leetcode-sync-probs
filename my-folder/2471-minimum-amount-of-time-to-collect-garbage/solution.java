class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int gIndex = 0;
        int pIndex = 0;
        int mIndex = 0;

        //create travel prefix sum array
        int sum = 0;
        for(int i = 0; i < travel.length; i++){
            sum += travel[i];
            travel[i] = sum;
        }

        for(int i = 0; i < garbage.length; i++){
            //set indices of last time M,P,G were seen
            for(char c : garbage[i].toCharArray()){
                if(c == 'M') mIndex = i;
                else if(c == 'P') pIndex = i;
                else gIndex = i;
                ans += 1;
            }
        }
        
        if(mIndex != 0) ans+= travel[mIndex - 1];
        if(pIndex != 0) ans+= travel[pIndex - 1];
        if(gIndex != 0) ans+= travel[gIndex - 1];

        return ans;
    }
}
