class Solution {
    public int compareVersion(String version1, String version2) {
        String[] t1 = version1.split("\\."); //BUG trick for regex.
        String[] t2 = version2.split("\\.");
  
        
        
        for (int i = 0; i < t1.length || i < t2.length; i++) {
            int d1 = (i < t1.length) ? Integer.valueOf(t1[i]) : 0;
            int d2 = (i < t2.length) ? Integer.valueOf(t2[i]) : 0;
            if (Integer.compare(d1, d2) == 0) continue;
            else return Integer.compare(d1, d2);
        }
        
        return 0;
    }
}