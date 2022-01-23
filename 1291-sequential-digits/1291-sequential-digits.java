class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String seq = "123456789";
        int n = 10;
        List<Integer> nums = new ArrayList();
        
        int lowL = String.valueOf(low).length();
        int highL = String.valueOf(high).length();
        for (int l = lowL; l <= highL; l++) {
            for (int start = 0; start < n - l; start++) {
                int num = Integer.parseInt(seq.substring(start, start + l));
                if (num >= low && num <= high) nums.add(num);
            }
        }
        return nums;
    }
}