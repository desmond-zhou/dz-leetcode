import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    final int[] singleSkip = new int[]{0, 0};

    public boolean possiblyEquals(String s1, String s2) {
        return recurse(s1, 0, 0, s2, 0, 0);
    }

    private Set<int[]> extractSkips(String s1, int start1) {
        Set<int[]> result = new HashSet<>();
        generateSkipsRecur(s1, start1, result, 0, 0);
        return result;
    }

    private void generateSkipsRecur(String string, int digitStart, Set<int[]> result, int valueSoFar, int lengthSoFar) {
        int end = digitStart;
        if (end > string.length() - 1 || !Character.isDigit(string.charAt(end))) {
            result.add(new int[]{lengthSoFar, valueSoFar});
            return;
        }
        int curNum = 0;
        while (end < string.length() && Character.isDigit(string.charAt(end))) {
            curNum = curNum * 10 + Character.getNumericValue(string.charAt(end));
            generateSkipsRecur(string, end + 1, result, valueSoFar + curNum, lengthSoFar + end - digitStart + 1);
            end++;
        }
    }


    HashSet<List<Integer>> failMemo = new HashSet<>();

    private boolean recurse(String string1, int i1, int wildcards1, String string2, int i2, int wildCards2) {
        int commonReduce = Math.min(wildcards1, wildCards2);
        wildcards1 -= commonReduce;
        wildCards2 -= commonReduce;

        while (true) {
            if (wildcards1 > 0) {
                if (i2 >= string2.length()) return false;
                if (Character.isAlphabetic(string2.charAt(i2))) {
                    wildcards1--;
                    i2++;
                } else break;
            } else if (wildCards2 > 0) {
                if (i1 >= string1.length()) return false;
                if (Character.isAlphabetic(string1.charAt(i1))) {
                    wildCards2--;
                    i1++;
                } else break;
            } else {
                if (i2 >= string2.length() && i1 >= string1.length()) return true;
                else if (i2 >= string2.length()) return false;
                else if (i1 >= string1.length()) return false;
                else if (Character.isAlphabetic(string1.charAt(i1)) && Character.isAlphabetic(string2.charAt(i2))) {
                    if (string1.charAt(i1) != string2.charAt(i2)) return false;
                    i1++;
                    i2++;
                } else break;
            }
        }

        final List<Integer> state = List.of(i1, wildcards1, i2, wildCards2);

        if (failMemo.contains(state)) return false;

        Set<int[]> skips1 = i1 < string1.length() && Character.isDigit(string1.charAt(i1)) ? extractSkips(string1, i1) : Set.of(singleSkip);
        Set<int[]> skips2 = i2 < string2.length() && Character.isDigit(string2.charAt(i2)) ? extractSkips(string2, i2) : Set.of(singleSkip);

        for (int[] candidates1 : skips1) {
            for (int[] candidates2 : skips2) {
                int newI1 = i1 + candidates1[0];
                int newI2 = i2 + candidates2[0];

                int wild1 = wildcards1 + candidates1[1];
                int wild2 = wildCards2 + candidates2[1];

                boolean result = recurse(string1, newI1, wild1, string2, newI2, wild2);
                if (result) return true;
            }
        }

        failMemo.add(state);
        return false;
    }
}