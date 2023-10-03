class Solution {
    public int maxVowels(String s, int k) {

        int[] vowels = new int[128];
        vowels['a'] = 1;
        vowels['e'] = 1;
        vowels['i'] = 1;
        vowels['o'] = 1;
        vowels['u'] = 1;

        int ans = 0;
        int count = 0;

        for(int i = 0; i < k; i++){
            count += vowels[s.charAt(i)];
        }
        ans = count;
        
        for(int i = k; i < s.length(); i++){
            count += vowels[s.charAt(i)];
            count -= vowels[s.charAt(i - k)];
            ans = Math.max(ans, count);

            if(ans == k) return ans;
        }
        return ans;
    }
}
