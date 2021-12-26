class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        StringBuilder result = new StringBuilder();
        for (int d1 = 0; d1 < num1.length(); d1++) {
            for (int d2 = 0; d2 < num2.length(); d2++) {
                fold(result, num1, num2, d1, d2);
            }
        }
        return result.reverse().toString().replaceFirst("^0+(?!$)", "");
    }
    
    private void fold(StringBuilder r, String num1, String num2, int d1, int d2) {
        int result = Character.getNumericValue(num1.charAt(d1)) 
            * Character.getNumericValue(num2.charAt(d2));
        int dSum = d1 + d2;
        if (dSum >= r.length()) {
            r.setLength(dSum+1);
            r.setCharAt(dSum, '0');
        }
        int carry = 0;
        //System.out.println("Apply: " + result * Math.pow(10, dSum));
        while (result > 0 || carry > 0) {
            int dig = result % 10;
            if (dSum >= r.length()) {
                r.setLength(dSum+1);
                r.setCharAt(dSum, '0');
            }
            int ori = Character.getNumericValue(r.charAt(dSum));
            
            int outcome = dig + ori + carry;
            int odig = outcome % 10;
            char odigChar = String.valueOf(odig).charAt(0);
            r.setCharAt(dSum, odigChar);
            
            dSum++;
            carry = outcome / 10;
            result = result / 10;
        }
    }
}


//abcde
//  xyz

//  abcde * z
// abcde  * y
//abcde   * x

//abcde
//    z
//    e 