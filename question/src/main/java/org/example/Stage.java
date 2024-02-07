package org.example;

import java.util.List;

public abstract class Stage {
    /**
     * Return the previous letter of the input parameter; if it is 'a', return 'z'.
     * @param c
     * @return
     */
    public  char getPreviousLetter(char c) {
        if (c == 'a') {
            return 'z';
        }
        return (char) (c - 1);
    }

    /**
     * Check if the string consists of all lowercase letters.
     * @param input
     * @return
     */
    public  boolean isAllLowerCase(String input){
        return input.matches("^[a-z]+$");
    }

    /**
     * Return the start and end positions of the first instance of three or more consecutive repeated letters.
     * @param str
     * @return
     */
    public int[] findConsecutiveRange(String str) {

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

    abstract List<String> dealWithInput(String input);

    public void printResults(String input) {
        List<String> resluts = dealWithInput(input);
        resluts.stream().forEach(item -> System.out.println(item));
    }


}
