class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sChar = new int[26];

        for(char sc : s.toCharArray()){
            sChar[sc - 'a']++;
        }

        for(char tc : t.toCharArray()){
            sChar[tc - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(sChar[i] != 0){
                return false;
            }
        }
        return true;
    }
}
