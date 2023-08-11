class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;

        int[] count = new int[256];

        for(char c : s.toCharArray()){
            count[c] += 1;
        }
        for(char c : t.toCharArray()){
            if(count[c] == 0) return false;
            count[c]--;
        }
        return true;
    }
}
