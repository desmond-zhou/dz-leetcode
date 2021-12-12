class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> s = new LinkedList<String>();
        StringBuilder token = new StringBuilder();
        
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                String tokenString = token.toString();
                if (tokenString.equals(".") || tokenString.equals("")) {
                    
                } else if (tokenString.equals("..")) {
                    if (!s.isEmpty()) s.pop();
                } else {
                    s.push(tokenString);
                }
                token = new StringBuilder();
            } else {
                token.append(c);
            }
        }
        
        String tokenString = token.toString();
        if (tokenString.equals(".") || tokenString.equals(""));
        else if (tokenString.equals("..")) {
            if (!s.isEmpty()) s.pop();
        } 
        else s.push(tokenString);
        
        StringBuilder result = new StringBuilder();
        result.append("/");
        while(!s.isEmpty()) {
            result.append(s.pollLast());
            if (!s.isEmpty()) result.append("/");
        }
            
        return result.toString();
    }
}