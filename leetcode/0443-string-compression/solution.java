class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;
        int index = 0;
        int i = 0;

        while(i < n){
            char currChar = chars[i];
            int count = 0;
            while(i < n && chars[i] == currChar){
                count++; i++;
            }

            //assignment work
            chars[index] = currChar;
            index++;
            if(count > 1){
                String countStr = String.valueOf(count);
                for(char ch : countStr.toCharArray()){
                    chars[index] = ch;
                    index++;
                }
            }
        }
        return index;
    }
}
