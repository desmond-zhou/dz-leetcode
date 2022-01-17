class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int nutDistance = 0;
        int maxSaving = Integer.MIN_VALUE; // may be always some negative savings
        for (int[] nut : nuts) {
            int nutToTree = calculate(nut, tree);
            nutDistance += nutToTree * 2;
            int nutToSquirrel = calculate(nut, squirrel);
            int saving = nutToTree - nutToSquirrel;
            maxSaving = Math.max(saving, maxSaving);
        }
        return nutDistance - maxSaving;
    }
    
    private int calculate(int[] obj1, int[] obj2) {
        return Math.abs(obj1[0] - obj2[0]) + Math.abs(obj1[1] - obj2[1]);
    }
}