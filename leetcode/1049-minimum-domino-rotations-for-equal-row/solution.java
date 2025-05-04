class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int result = check(tops[0], tops, bottoms);
        if(result != -1) return result;

        return check(bottoms[0], tops, bottoms);
    }
    private int check(int target, int[] tops, int[] bottoms){
        int topR = 0, botR = 0;

        for(int i = 0; i < tops.length; i++){
            if(target != tops[i] && target != bottoms[i]){
                return -1;
            }
            else if(target != tops[i]){
                topR++;
            }
            else if(target != bottoms[i]){
                botR++;
            }
        }
        return Math.min(topR, botR);
    }
}
