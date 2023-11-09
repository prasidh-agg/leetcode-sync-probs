class Solution {
    private int MOD = 1000000007;
    public int countHomogenous(String s) {
        char[] ch = s.toCharArray();
        long result = 0;
        long len = 0;
        for(int i = 0; i < ch.length; i++){
            if(i > 0 && ch[i] == ch[i-1]){
                len += 1;
            }
            else{
                len = 1;
            }
            result = (result + len) % MOD;
        }
        return (int)result;
    }
}
