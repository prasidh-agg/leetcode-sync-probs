class Solution {
    public String addBinary(String a, String b) {
        int p1 = a.length() - 1, p2 = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while(p1 >= 0 || p2 >= 0){
            int sum = carry;
            if(p1 >= 0) sum += a.charAt(p1--) - '0';
            if(p2 >= 0) sum += b.charAt(p2--) - '0';
            carry = (sum > 1) ? 1 : 0;
            res.append(sum % 2); 
        }
        if(carry == 1)res.append(carry);
        return res.reverse().toString();
    }
}
