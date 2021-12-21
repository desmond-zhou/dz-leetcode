class Result {
    int count;
    char chara;
    public Result(int count, char chara) {
        this.count = count;
        this.chara = chara;
    }
}

class Solution {
    public int compress(char[] chars) {
        int uncompressedI = 0;
        int compressedI = 0;
        
        while (uncompressedI < chars.length) {
            Result loadResult = load(uncompressedI, chars);
            uncompressedI = uncompressedI + loadResult.count;
            compressedI = store(loadResult.chara, loadResult.count, compressedI, chars);
        }
        
        return compressedI;
    }
    
    private Result load(int start, char[] chars) {
        char curChar = chars[start];
        int count = 1;
        while (start + count < chars.length && chars[start + count] == curChar) count++;
        return new Result(count, curChar);
    }
    
    private int store(char chara, int count, int start, char[] chars) {
        int curIndex = start;
        chars[curIndex] = chara;
        String countString = "";
        if (count > 1) {
            countString = Integer.toString(count);
            for (int i = 1; i <= countString.length(); i++) {
                chars[curIndex + i] = countString.charAt(i - 1);
            }
        }
        return start + 1 + countString.length();
    }
}