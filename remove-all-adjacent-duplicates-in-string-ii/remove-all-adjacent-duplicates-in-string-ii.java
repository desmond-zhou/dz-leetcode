class Solution {
    public String removeDuplicates(String s, int k) {
        LinkedList<int[]> dupStack = new LinkedList<>();
        int count = 1;
        char cur = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == cur) count++;
            else {
                dupStack.push(new int[]{cur, count});
                count = 1;
                cur = s.charAt(i);
            }
        }
        dupStack.push(new int[]{cur, count});
    
        LinkedList<int[]> pStack = new LinkedList<>();
        while (!dupStack.isEmpty()) {
            int[] dItem = dupStack.pop();
            int[] pItem = (pStack.isEmpty()) ? new int[]{dItem[0], 0} : pStack.pop();
            
            if (pItem[0] != dItem[0]) pStack.push(new int[]{pItem[0], pItem[1]});
            int nCount = (pItem[0] == dItem[0]) ? (dItem[1] + pItem[1]) % k : dItem[1] % k;
            if (nCount > 0) pStack.push(new int[]{dItem[0], nCount});
        }

        StringBuilder sb = new StringBuilder();
        while (!pStack.isEmpty()) {
            int[] entry = pStack.pop();
            for (int i = 0; i < entry[1]; i++) {
                sb.append((char) entry[0]);
            }
        }

        return sb.toString();
    }
}


// 0 dupStack n --> n pStack 0
// deeedbbcccbdaa --> 