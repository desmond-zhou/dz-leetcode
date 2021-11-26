/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int reads = (n / 4);
        int remain = (n % 4);
        int index = 0;
        
        for (int i = 0; i < reads; i++) {
            int read = read4(buf4);
            if (read == 0) break;
            for (int j = 0; j < read; j++) {
                buf[index] = buf4[j];
                index++;
            }
        }
        
        System.out.println("4:" + index);

        if (remain != 0) {
            int read = read4(buf4);
            for (int j = 0; j < Math.min(read, remain); j++) {
                buf[index] = buf4[j];
                index++;
            }
        }
        
        System.out.println(index);
        return index;
    }
}