class Solution {
    public int maxDepth(String s) {
        int answer = 0;
        int leftBraces = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                leftBraces++;
                answer = Math.max(answer, leftBraces);
            }
            else if(s.charAt(i) == ')') leftBraces--;
            else continue;
        }
        return answer;
    }
}
