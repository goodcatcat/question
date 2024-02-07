package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Utils.findConsecutiveRange;
import static org.example.Utils.isAllLowerCase;

/**
 * @ClassName Stage1
 * @Description
 * @Author liuweizhi
 * @Date 14:39 2024/2/7
 * @Version 1.0
 **/


public class Stage1 extends Stage {
    /**
     * #Stage 1 For a given string that only contains alphabet characters a-z, if 3 or more consecutive
     * characters are identical, remove them from the string. Repeat this process until
     * there is no more than 3 identical characters sitting beside each other.
     * @param input
     */
    @Override
    public List<String> dealWithInput(String input) {
        ArrayList<String> resultList = new ArrayList<>();
        if(input == null || input.isEmpty() || !isAllLowerCase(input) ){
            resultList.add("The input parameters is incorrect，Please check it.");
            return resultList;
        }

        if(input.length() < 3 ){
            resultList.add(input);
            return resultList;
        }

        while(!input.isEmpty()){
            int[] consecutiveRange = findConsecutiveRange(input);
            if(consecutiveRange[0] == -1){
                break;
            }
            String output = input.substring(0,consecutiveRange[0]) + input.substring(consecutiveRange[1]+1,input.length());
            resultList.add(output);
            input = output;
        }
        return resultList;
    }
}
