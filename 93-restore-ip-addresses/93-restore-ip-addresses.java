class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        restore(s, new StringBuilder(), 4, result);
        return result;
    }
    
    private void restore(String s, StringBuilder soFar, int remainingSeg, List<String> result) {
        if (s.length() == 0 && remainingSeg == 0) {
            result.add(soFar.toString());
        } 
        
        if (remainingSeg <= 0) return;
        
        int num = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = Character.getNumericValue(s.charAt(i));
            if (num == -1) {
                num = c;
            } else {
                num = num * 10 + c;
            }
            
            if (num >= 0 && num <= 255) {
                int originalLength = soFar.length();
                soFar.append(num);
                if (remainingSeg > 1) soFar.append(".");
                restore(s.substring(i+1, s.length()), soFar, remainingSeg - 1, result);
                soFar.setLength(originalLength);
            }
            
            if (num == 0) {
                break; // if processed zero, then have to go to the next segment
            }
        }
    }
}