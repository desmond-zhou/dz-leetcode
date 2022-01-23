class Solution {
    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2 ; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        //System.out.println("Arr: " + Arrays.toString(arr));
        for (int c1 = 0 ; c1 < arr.length; c1++) {
            for (int c2 = 0; c2 < arr.length; c2 ++) {
                if (c1 == c2) continue;
                int hour = arr[c1] * 10 + arr[c2];
                if (hour <= 23) {
                    for (int c3 = 0; c3 < arr.length; c3 ++) {
                        if (c3 == c1 || c3 == c2) continue;
                        for (int c4 = 0; c4 < arr.length; c4++) {
                            if (c4 == c1 || c4 == c2 || c4 == c3) continue;
                            int minute = arr[c3] * 10 + arr[c4];
                            if (minute <= 59) return arr[c1] + "" + arr[c2] + ":" + arr[c3] + "" + arr[c4];
                        }
                    }
                }
            }
        }
        return "";
    }
    
}