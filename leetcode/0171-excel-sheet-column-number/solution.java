class Solution {
    public int titleToNumber(String columnTitle) {

       int res = 0;
       int power = columnTitle.length() - 1;

       for(char c : columnTitle.toCharArray()){
           res += (c - 'A' + 1) * Math.pow(26, power--);
       } 
       return res;
    }
}
