class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        helper(0, s, new ArrayList<String>(), ans);
        return ans;
    }

    private void helper(int index, String s, List<String> ds, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                ds.add(s.substring(index, i+1));
                helper(i + 1, s, ds, ans);
                ds.remove(ds.size() - 1);
            }

        }
    }

    private static boolean isPalindrome(String st, int l, int r){
        while(l <= r){
            if(st.charAt(l++) != st.charAt(r--)) return false;
        }
        return true;
    }
}
