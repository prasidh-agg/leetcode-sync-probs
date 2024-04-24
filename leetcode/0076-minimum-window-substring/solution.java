class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        //build a map for what do we need
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //keep a count of how many chars have matched 
        int matched = 0;
        int left = 0;
        int minLen = s.length() + 1;
        int minStart = 0;

        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0) matched++;
            }

            while(matched == map.size()){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    minStart = left;
                }
                char deleted = s.charAt(left++);
                if(map.containsKey(deleted)){
                    if(map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(minStart, minStart + minLen);
    }
}
