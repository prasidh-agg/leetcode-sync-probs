class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        if (t.length() > n)
            return "";

        int[] mp = new int[128];

        // build frequency map
        for (char ch : t.toCharArray())mp[ch - 'A']++;

        int requiredCount = t.length();
        int i = 0, j = 0;

        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;

        while (j < n) {
            char ch = s.charAt(j);

            if (mp[ch - 'A'] > 0) requiredCount--;

            mp[ch - 'A']--;

            while (requiredCount == 0) {

                int currWindowSize = j - i + 1;

                if (minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i;
                }

                char startChar = s.charAt(i);
                mp[startChar - 'A']++;

                if(mp[startChar - 'A'] > 0)requiredCount++;

                i++;
            }

            j++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}
