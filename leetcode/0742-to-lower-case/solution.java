class Solution {
    public String toLowerCase(String s) {
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            if((int)c >= 65 && (int)c <= 90){
                res.append((char)(c + 32));
            }
            else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
