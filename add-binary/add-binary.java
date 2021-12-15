class Solution {
    public String addBinary(String a, String b) {
        LinkedList<String> res = new LinkedList<>();
        int pos = 0;
        int carry = 0;
        while (a.length() - 1 - pos >= 0 || b.length() - 1 - pos >= 0) {
            int pa = a.length() - 1 - pos >= 0 && a.charAt(a.length() - 1 - pos) == '1' ? 1 : 0;
            int pb = b.length() - 1 - pos >= 0 && b.charAt(b.length() - 1 - pos) == '1' ? 1 : 0;
            
            int r = (pa + pb + carry) % 2;
            carry = (pa + pb + carry) >= 2 ? 1 : 0;
            
            res.push(String.valueOf(r));
            pos++;
        }
        
        if (carry > 0) res.push("1");
        
        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.pop());
        }
        
        return sb.toString();
    }
}