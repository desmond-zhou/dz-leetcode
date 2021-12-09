class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        
        int s = 0;
        int e = 0;
        int totalWidth = 0;
        while (e < words.length) {
            while (e < words.length && totalWidth <= maxWidth) {
                int newTotalWidth = totalWidth + words[e].length();
                if (s != e) newTotalWidth++;
                if (newTotalWidth > maxWidth) {
                    break;
                }
                totalWidth = newTotalWidth;
                e++;
            }
            e--;
            boolean isLastLine = e == words.length - 1;
            result.add(buildLine(words, s, e, maxWidth, isLastLine));
            s = e + 1;
            e = s;
            totalWidth = 0;
        }
        
        return result;
    }
    
    private static final String BLANK = " ";
    
    public String buildLine(String[] words, int s, int e, int maxWidth, boolean isLastLine) {
        int numLetters = 0;
        for (int i = s; i <= e; i++) {
            numLetters += words[i].length();
        }
        
        int numWords = e - s + 1;
        StringBuilder sb = new StringBuilder();
        
        int numSpaces = maxWidth - numLetters;
        int numGaps = (numWords > 1 || isLastLine) ? numWords - 1 : 1;
        int charEach = (numGaps == 0) ? 0 : numSpaces / numGaps;
        int gapWithExtra = (numGaps == 0) ? 0 : numSpaces % numGaps;
        
        if (isLastLine) {
            int numRemainingSpace = numSpaces - numGaps;
            //if (numWords == 1) numGaps = 0;
            for (int i = s; i <= e; i++) {
                sb.append(words[i]);
                if (i - s < numGaps) {
                    sb.append(BLANK);
                }
            }
            for (int i = 0; i < numRemainingSpace; i++) {
                sb.append(BLANK);
            }
        } else {
            for (int i = s; i <= e; i++) {
                    sb.append(words[i]);
                    if (i - s < numGaps) {
                        for (int c = 0; c < charEach; c++) {
                            sb.append(BLANK);
                        };
                        if (i - s < gapWithExtra) sb.append(BLANK);
                    }
            }
        }
        
        String line = sb.toString();
        //System.out.println(line);
        return line;
    }
}