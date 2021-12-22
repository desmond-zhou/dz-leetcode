class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mat = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            mat.putIfAbsent(c, 0);
            mat.compute(c, (k, v) -> v + 1);
        }
        for (char c: ransomNote.toCharArray()) {
            if (!mat.containsKey(c)) return false;
            mat.compute(c, (k, v) -> v == 1 ? null : v - 1);
        }
        return true;
    }
}