class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int index = 0;
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
            index++;
        }
        index = 0;
        for(char c : s.toCharArray()){
            if(arr[c - 'a'] == 1) return index;
            index++;
        }
        return -1;
    }
}
