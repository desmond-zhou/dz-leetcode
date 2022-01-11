class Solution {
    public String reverseVowels(String s) {
        char[] buffer = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (!vowels.contains(String.valueOf(s.charAt(start)))) {
                start++;
            } else if (!vowels.contains(String.valueOf(s.charAt(end)))) {
                end--;
            } else {
                buffer[start] = s.charAt(end);
                buffer[end] = s.charAt(start);
                start++;
                end--;
            }       
        }
        return new String(buffer);
    }
}