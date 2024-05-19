class Solution {
    public String fractionAddition(String expression) {

        int num = 0, den = 1;

        if(Character.isDigit(expression.charAt(0))){
            expression = "+" + expression;
        }

        int i = 0, n = expression.length();
        while(i < n){
            int sign = expression.charAt(i) == '-' ? -1 : 1;
            i++;

            int j = i;
            while(j < n && expression.charAt(j) != '-' && expression.charAt(j) != '+'){
                j++;
            }

            String s = expression.substring(i, j);
            String[] parts = s.split("/");

            int newNum = Integer.parseInt(parts[0]), newDen = Integer.parseInt(parts[1]);

            num = num * newDen + (sign * den * newNum);
            den = den * newDen;
            i = j;
        }

        int gcd = getGCD(Math.abs(num), den);
        num /= gcd;
        den /= gcd;

        return num + "/" + den;
    }

    private int getGCD(int a, int b){
        return b == 0 ? a : getGCD(b, a % b);
    }
}
