class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if(m > n) return false;
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        int p1 = 0, p2 = 0;

        while(p1 < m && p2 < n){
            if(sarr[p1] == tarr[p2]){
                p1++;
            }
            p2++;
        }
        return p1 == m;
    }
}
