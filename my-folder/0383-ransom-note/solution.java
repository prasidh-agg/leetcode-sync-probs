class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mag = new int[26];
        int[] ran = new int[26];

        for(int i = 0; i < magazine.length(); i++){
            mag[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if(mag[ch - 'a'] < 1){
                return false;
            }
            else{
                mag[ch - 'a']--;
            }
        }
        return true;
    }
}
