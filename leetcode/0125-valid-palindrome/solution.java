class Solution {

    //Time - O(n), Space - O(1)
    public boolean isPalindrome(String s) {
        // Can use Character.isLetterOrDigit to have a faster solution but this is
        // more intuitive
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++; end--;
        }
        return true;
    }
}
