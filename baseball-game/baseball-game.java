class Solution {
    public int calPoints(String[] ops) {
        int[] result = new int[ops.length];
        int sum = 0;
        int rIndex = 0;
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            switch (s) {
                case "+": 
                    result[rIndex] = result[rIndex-1] + result[rIndex-2];
                    sum += result[rIndex];
                    rIndex++;
                    break;
                case "D":
                    result[rIndex] = result[rIndex-1] * 2;
                    sum += result[rIndex];
                    rIndex++;
                    break;
                case "C":
                    rIndex--;
                    sum = sum - result[rIndex];
                    break;
                default:
                    result[rIndex] = Integer.valueOf(s); 
                    sum += result[rIndex];
                    rIndex++;
            }
            //System.out.println("s: " + s + " result: " + Arrays.toString(result) + " sum: " + sum);

        }
        
        return sum;
    }
}