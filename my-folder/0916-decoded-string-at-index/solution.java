class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLen = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isLetter(ch)){
                decodedLen++;
            }
            else{
                decodedLen *= ch - '0';
            }
        }

        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            k = (int)(k % decodedLen);
            
            if(k == 0 && Character.isLetter(ch)) return String.valueOf(ch);

            if(Character.isDigit(ch)){
                decodedLen /= s.charAt(i) - '0';
            }
            else{
                decodedLen--;
            }
        }
        return "";
    }
}
