class Solution {
    public String addStrings(String num1, String num2) {
        int pos =- 0;
        int carry = 0;
        Stack<String> s = new Stack<>();
        while (num1.length() - 1 - pos >= 0 || num2.length() - 1 - pos >= 0) {
            int d1 = getPos(num1, pos);
            int d2 = getPos(num2, pos);
            
            int sum = d1 + d2 + carry;
            int dr = sum % 10;
            carry = sum / 10;
            
            s.push(String.valueOf(dr));
            pos++;
        }
        if (carry != 0) s.push(String.valueOf(carry));
        
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty())
            sb.append(s.pop());
        
        return sb.toString();
            
    }
    
    private int getPos(String num, int pos) {
        int i = num.length() - 1 - pos;
        if (i < 0) return 0;
        else return Character.getNumericValue(num.charAt(i));
    }

}