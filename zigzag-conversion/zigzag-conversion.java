class Solution {
    public String convert(String s, int numRows) {
        //BUG: edge case, only one row
        if (numRows == 1) return s;
        StringBuilder[] results = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++){
            results[i] = new StringBuilder();
        }
        
        int row = 0;
        boolean down = true;
        for (char c : s.toCharArray()) {
            results[row].append(c);
            if (row == numRows - 1) {
                down = false;
                row--;
            } else if (row == 0) {
                down = true;
                row++;
            } else if (down) {
                row++;
            } else {
                row--;
            }
        }
        
        StringBuilder fullResult = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            fullResult.append(results[i].toString());
        }
        
        return fullResult.toString();
    }
}