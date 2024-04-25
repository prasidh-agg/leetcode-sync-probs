class Solution {
    public int numTeams(int[] rating) {
        int res = 0;

        for(int j = 0; j < rating.length; j++){
        int smaller_left = 0, smaller_right = 0;
        int bigger_left = 0, bigger_right = 0;

            for(int i = j - 1; i >= 0; i--){
                if(rating[i] < rating[j]){
                    smaller_left++;
                }
                else if(rating[i] > rating[j]){
                    bigger_left++;
                }
            }
            for(int k = j + 1; k < rating.length; k++){
                if(rating[k] < rating[j]){
                    smaller_right++;
                }
                else if(rating[k] > rating[j]){
                    bigger_right++;
                }
            }
            res += smaller_left * bigger_right + smaller_right * bigger_left;
        }

        return res;
    }
}
