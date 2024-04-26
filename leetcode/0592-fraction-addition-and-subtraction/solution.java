class Fraction {
    private int num;
    private int den;

    public Fraction(int numerator, int denominator) {
        this.num = numerator;
        this.den = denominator;
        reduce();
    }

    public void add(Fraction other) {
        this.num = this.num * other.den + other.num * this.den;
        this.den = this.den * other.den;
        reduce();
    }
    public Fraction negate() {
        return new Fraction(-this.num, this.den);
    }


    private void reduce() {
        int gcd = gcd(Math.abs(this.num), this.den);
        this.num /= gcd;
        this.den /= gcd;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    public static Fraction parseFraction(String frac) {
        String[] parts = frac.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        return new Fraction(numerator, denominator);
    }
}

class Solution {
    public String fractionAddition(String expression) {
        if (Character.isDigit(expression.charAt(0))) {
            expression = "+" + expression;
        }
        Fraction result = new Fraction(0, 1); // Initialize with 0/1
        int i = 0, n = expression.length();
        while (i < n) {
            int sign = expression.charAt(i) == '-' ? -1 : 1;
            i++;
            int j = i;
            while (j < n && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            String s = expression.substring(i, j);
            Fraction f = Fraction.parseFraction(s);
            if (sign == -1) {
                f = f.negate(); // Apply the negative sign
            }
            result.add(f);
            i = j;
        }
        return result.toString();
    }
}

