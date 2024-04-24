class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        String noHeadNoTail = ss.substring(1, ss.length() - 1);
        return noHeadNoTail.contains(s);
    }
}
