class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, ans, new StringBuilder(), 0, 0);
        return ans;
    }
    private static void helper(int n, List<String> ans, StringBuilder curr, int open, int close){

        if(close > open) return;

        if(close == n && open == n){
            ans.add(new String(curr.toString()));
            return;
        }
        if(open != n){
            curr.append("(");
            helper(n, ans, curr, open + 1, close);
            curr.deleteCharAt(curr.length() - 1);
        }
        curr.append(")");
        helper(n, ans, curr, open, close + 1);
        curr.deleteCharAt(curr.length() - 1);
    }
}
