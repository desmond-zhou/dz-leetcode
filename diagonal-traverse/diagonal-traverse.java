class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int yl = mat.length;
        int xl = (yl == 0) ? 0 : mat[0].length;
        int yM = yl - 1;
        int xM = xl - 1;
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int total = 0;
        for (int sum = 0; sum <= yM + xM; sum++){
            int startY;
            int startX;
            if (sum <= yM) {
                startY = sum;
                startX = 0;
            } else {
                startY = yM;
                startX = sum - yM;
            }
            
            int y = startY;
            int x = startX;
            ArrayList<Integer> resultLine = new ArrayList<>();
            while (y >= 0 && x <= xM) {
                resultLine.add(mat[y][x]);
                total++;
                y--;
                x++;
            }
            results.add(resultLine);
        }
        
        int[] resultArr = new int[total];
        int index = 0;
        boolean upArc = true;
        for (List<Integer> resultLine : results) {
            for (int i = 0; i < resultLine.size(); i++) {
                int lineIndex = upArc ? i : resultLine.size() - 1 - i;
                resultArr[index] = resultLine.get(lineIndex);
                index++;
            }
            upArc = !upArc;
        }
        return resultArr;
    }
}