class Solution {
    public int characterReplacement(String s, int k) {

        int start = 0, maxLen = 0, mostFreq = 0;
        int[] freq = new int[26];

        for(int end = 0; end < s.length(); end++){
            // get the character at the end of the window, subtract A to get an index
            // for the freq array
            freq[s.charAt(end) - 'A']++;
            mostFreq = Math.max(mostFreq, freq[s.charAt(end) - 'A']);

            if(end - start + 1 - mostFreq > k){
                freq[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(end - start + 1, maxLen);
        }  
        return maxLen;
    }
}
