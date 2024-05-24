class Solution {
    public boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[10];
        sb.append(String.valueOf(n));
        sb.append(String.valueOf(2 * n));
        sb.append(String.valueOf(3 * n));

        String str = sb.toString();

        if(str.indexOf('0') != -1) return false;

        for(char c : str.toCharArray()){
            count[Character.getNumericValue(c)]++;
        }

        for(int i = 1; i < 10; i++){
            if(count[i] != 1) return false;
        }
        
        return true;
    }
}
