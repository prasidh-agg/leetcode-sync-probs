class Solution {
    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }
    public boolean isPalindrome(String word){
        int l = 0, r = word.length() - 1;
        while(l < r){
            if(word.charAt(l++) != word.charAt(r--)) return false;
        }
        return true;
    }
}
