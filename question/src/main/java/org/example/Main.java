package org.example;

public class Main {
    public static void main(String[] args) {
        String input = "aaabbbbbccdeeeffffggghhh";
        // stage 1
        removeAndPrint(input);
        // stage 2
        replaceAndPrint(input);
    }


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
     * #Stage 1 For a given string that only contains alphabet characters a-z, if 3 or more consecutive
     * characters are identical, remove them from the string. Repeat this process until
     * there is no more than 3 identical characters sitting beside each other.
     * @param input
     */
    public static void removeAndPrint(String input){

        if(input == null || input.isEmpty() || !isAllLowerCase(input) ){
            System.out.println("The input parameters is incorrect，Please check it.");
            return;
        }

        if(input.length() < 3 ){
            System.out.println(input);
            return;
        }

        while(!input.isEmpty()){
            int[] consecutiveRange = findConsecutiveRange(input);
            if(consecutiveRange[0] == -1){
                System.out.println(input);
                break;
            }
            String output = input.substring(0,consecutiveRange[0]) + input.substring(consecutiveRange[1]+1,input.length());
            System.out.println(output);
            input = output;
        }
    }

    /**
     * Return the previous letter of the input parameter; if it is 'a', return 'z'.
     * @param c
     * @return
     */
    public static char getPreviousLetter(char c) {
        if (c == 'a') {
            return 'z';
        }
        return (char) (c - 1);
    }

    /**
     * #Stage 2 - advanced requirement
     * Instead of removing the consecutively identical characters, replace them with a
     * single character that comes before it alphabetically.
     * @param input
     */
    public static void replaceAndPrint(String input){
        if(input == null || input.isEmpty() || !isAllLowerCase(input)){
            System.out.println("The input parameters is incorrect，Please check it.");
        }

        if(input.length() < 3 ){
            System.out.println(input);
            return;
        }

        while(!input.isEmpty()){
            int[] consecutiveRange = findConsecutiveRange(input);
            if(consecutiveRange[0] == -1){
                System.out.println(input);
                break;
            }
            String output = input.substring(0,consecutiveRange[0])
                    + getPreviousLetter(input.charAt(consecutiveRange[0]))
                    + input.substring(consecutiveRange[1]+1,input.length());
            String outputStr = output + ","
                    + input.substring(consecutiveRange[0],consecutiveRange[1]+1)
                    + " is replaced by "
                    + getPreviousLetter(input.charAt(consecutiveRange[0]));
            System.out.println(outputStr);
            input = output;
        }

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
