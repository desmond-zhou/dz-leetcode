class Solution {
    public int minOperations(String[] logs) {
        Stack<String> wd = new Stack<>();
        
        for(String l : logs) {
            if (l.equals("../")) {
                if (!wd.isEmpty()) wd.pop();
                continue;
            } else if (l.equals("./")) {
                continue;
            } else {
                String newD = l.substring(0, l.length()-1);
                wd.push(newD);  
            } 
        }
        
        return wd.size();
    }
}