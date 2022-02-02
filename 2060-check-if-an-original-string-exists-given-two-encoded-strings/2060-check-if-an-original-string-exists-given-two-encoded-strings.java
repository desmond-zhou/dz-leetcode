class Solution {
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
                if (isEnd(i2, string2)) return false; // wildcard but the other is done
                if (isLetter(i2, string2)) { // wild card used
                    wildcards1--;
                    i2++;
                }
                else break; // wildcard meeting number
            } else if (wildCards2 > 0) {
                if (isEnd(i1, string1)) return false; // wildcard but the other is done
                if (isLetter(i1, string1)) { // wild card used
                    wildCards2--;
                    i1++;
                }
                else break; // wildcard meeting number
            } else {
                if (isEnd(i2, string2) && isEnd(i1, string1)) return true; // both happen to be done
                else if (isEnd(i2, string2) || isEnd(i1, string1)) return false; // one ended while the other did not
                else if (isLetter(i1, string1) && isLetter(i2, string2)) { // both letter used
                    if (string1.charAt(i1) != string2.charAt(i2)) return false; // letter with no match is fail
                    i1++;
                    i2++;
                }
                else break;
            }
        }

        // processed all cancellations and letters, one side may have wildcard, the other side will have new numbers

        final List<Integer> memoState = List.of(i1, wildcards1, i2, wildCards2); // memo to optimize failed state
        if (failMemo.contains(memoState)) return false; // check memo

        // generate all possible wildcards from numerical values
        Set<int[]> skips1 = !isEnd(i1, string1) && !isLetter(i1, string1) ? extractSkips(string1, i1) : Set.of(singleSkip);
        Set<int[]> skips2 = !isEnd(i2, string2) && !isLetter(i2, string2) ? extractSkips(string2, i2) : Set.of(singleSkip);

        for (int[] candidates1 : skips1) {
            for (int[] candidates2 : skips2) {
                boolean result = recurse(
                        i1 + candidates1[0],
                        wildcards1 + candidates1[1],
                        i2 + candidates2[0],
                        wildCards2 + candidates2[1]); // recurse for all combinations of possible wildcards
                
                if (result) return true; // if any of the recursion yielded good result, return true
            }
        }

        failMemo.add(memoState); // if no recursion yielded good result, add to memo and return false
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