package org.example;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author liuweizhi
 * @Date 14:40 2024/2/7
 * @Version 1.0
 **/

public class Utils {
    /**
     * Return the start and end positions of the first instance of three or more consecutive repeated letters.
     * @param str
     * @return
     */
    public static int[] findConsecutiveRange(String str) {

        if(str.length()<3){
            return new int[]{-1, -1};
        }
        for (int i = 0; i < str.length() - 2; i++) {
            int count = 1;
            while (i + count < str.length() && str.charAt(i) == str.charAt(i + count)) {
                count++;
            }
            if (count >= 3) {
                return new int[]{i, i + count - 1};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Check if the string consists of all lowercase letters.
     * @param input
     * @return
     */
    public static boolean isAllLowerCase(String input){
        return input.matches("^[a-z]+$");
    }
}
