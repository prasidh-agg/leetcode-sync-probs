class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] sarr = new int[200];
        int[] tarr = new int[200];
        
        for(int i = 0; i < s.length(); i++){
            if(sarr[s.charAt(i)] != tarr[t.charAt(i)]){
                return false;
            }
            else{
                sarr[s.charAt(i)] = i + 1;
                tarr[t.charAt(i)] = i + 1;
            }
        }
        return true;

    }
}
