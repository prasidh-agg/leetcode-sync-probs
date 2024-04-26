class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int l = 0, r = 0;
        int maxLen = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            l = (arr[c] > 0) ? Math.max(arr[c], l) : l;
            arr[c] = r + 1;
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
