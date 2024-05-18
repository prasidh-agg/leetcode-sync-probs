class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] cArr = s.toCharArray();
        for(char c : cArr){
            arr[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(arr[cArr[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
