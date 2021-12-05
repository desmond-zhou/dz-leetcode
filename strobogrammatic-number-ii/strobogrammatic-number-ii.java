class Solution {
    char[][] sPairs = {{'6','9'}, {'9','6'}, {'1','1'}, {'8','8'}, {'0','0'}};
    char[] sSingles = new char[]{'1', '8', '0'};
    int half;
    
    public List<String> findStrobogrammatic(int n) {
        int half = n / 2;
        boolean isOdd = false;
        if (n % 2 == 1) {
            half++;
            isOdd = true;
        }
        
        this.half = half;
        
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        search(half, results, sb, isOdd);
        
        List<String> fullResults = new ArrayList<>();
        StringBuilder fullSB = new StringBuilder();
        for (String result : results) {
            fullSB.append(result);
            for (int i = n / 2 - 1; i >= 0; i--) {
                switch(result.charAt(i)) {
                    case  '6':
                        fullSB.append('9');
                        break;
                    case '9':
                        fullSB.append('6');
                        break;
                    case '8':
                        fullSB.append('8');
                        break;
                    case '1':
                        fullSB.append('1');
                        break;
                    case '0':
                        fullSB.append('0');
                        break;
                }
            }
            
            if (!(fullSB.charAt(0) == '0' && n > 1)) {
                fullResults.add(fullSB.toString());
            }
            fullSB = new StringBuilder();
        }
        
        return fullResults;
    }
    
    public void search(int n, List<String> results, StringBuilder sb, boolean isOdd) {
        if (n == 0) {
            results.add(sb.toString());
            return;
        }
        if (n == 1 && isOdd) {
            for (char single : sSingles) {
                sb.append(single);
                search(n-1, results, sb, isOdd);
                sb.setLength(sb.length() - 1);
            }
        } else {
            for (char[] pair : sPairs) {
                sb.append(pair[0]);
                search(n-1, results, sb, isOdd);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}