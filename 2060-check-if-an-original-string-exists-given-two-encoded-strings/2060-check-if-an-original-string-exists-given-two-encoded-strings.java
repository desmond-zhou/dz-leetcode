class Solution {

    /**
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean result = sol.possiblyEquals("g141g9g94q592q62g78g779q61g779g28", "g2q4g795g87g828q321g532g195q11g77");
        System.out.println(result);
    } **/

    final int[] singleSkip = new int[]{0, 0};
    final HashSet<List<Integer>> failMemo = new HashSet<>();
    String string1;
    String string2;

    public boolean possiblyEquals(String s1, String s2) {
        this.string1 = s1;
        this.string2 = s2;
        return recurse( 0, 0, 0, 0);
    }

    private boolean recurse(int i1, int wildcards1, int i2, int wildCards2) {
        int commonReduce = Math.min(wildcards1, wildCards2);
        wildcards1 -= commonReduce;
        wildCards2 -= commonReduce;

        while (true) {
            if (wildcards1 > 0) {
                if (isEnd(i2, string2)) return false;
                if (isLetter(i2, string2)) {
                    wildcards1--;
                    i2++;
                }
                else break;
            } else if (wildCards2 > 0) {
                if (isEnd(i1, string1)) return false;
                if (isLetter(i1, string1)) {
                    wildCards2--;
                    i1++;
                }
                else break;
            } else {
                if (isEnd(i2, string2) && isEnd(i1, string1)) return true; // both done
                else if (isEnd(i2, string2) || isEnd(i1, string1)) return false; // one end other did not
                else if (isLetter(i1, string1) && isLetter(i2, string2)) { // both letter
                    if (string1.charAt(i1) != string2.charAt(i2)) return false; // no match is fail
                    i1++;
                    i2++;
                }
                else break;
            }
        }

        // one of the wildcard and following letter is exhausted, the other wildcard still remains

        final List<Integer> memoState = List.of(i1, wildcards1, i2, wildCards2);

        if (failMemo.contains(memoState)) return false;

        Set<int[]> skips1 = !isEnd(i1, string1) && !isLetter(i1, string1) ? extractSkips(string1, i1) : Set.of(singleSkip);
        Set<int[]> skips2 = !isEnd(i2, string2) && !isLetter(i2, string2) ? extractSkips(string2, i2) : Set.of(singleSkip);

        for (int[] candidates1 : skips1) {
            for (int[] candidates2 : skips2) {
                boolean result = recurse(
                        i1 + candidates1[0],
                        wildcards1 + candidates1[1],
                        i2 + candidates2[0],
                        wildCards2 + candidates2[1]);
                if (result) return true;
            }
        }

        failMemo.add(memoState);
        return false;
    }

    private Set<int[]> extractSkips(String string, int start) {
        Set<int[]> result = new HashSet<>();
        generateSkipsRecur(string, start, result, 0, 0);
        return result;
    }

    private void generateSkipsRecur(String string, int digitStart, Set<int[]> result, int valueSoFar, int lengthSoFar) {
        int end = digitStart;
        if (isEnd(end, string) || isLetter(end, string)) {
            result.add(new int[]{lengthSoFar, valueSoFar});
            return;
        }
        int curNum = 0;
        while (!isEnd(end, string) && !isLetter(end, string)) {
            curNum = curNum * 10 + Character.getNumericValue(string.charAt(end));
            int segLength = end - digitStart + 1;
            generateSkipsRecur(string, end + 1, result, valueSoFar + curNum, lengthSoFar + segLength);
            end++;
        }
    }

    private boolean isLetter(int index, String string) {
        return Character.isAlphabetic(string.charAt(index));
    }

    private boolean isEnd(int index, String string) {
        return index >= string.length();
    }
}