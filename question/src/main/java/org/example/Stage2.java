package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Utils.findConsecutiveRange;
import static org.example.Utils.isAllLowerCase;

/**
 * @ClassName Stage2
 * @Description
 * @Author liuweizhi
 * @Date 14:39 2024/2/7
 * @Version 1.0
 **/

public class Stage2 extends Stage {

    /**
     * #Stage 2 - advanced requirement
     * Instead of removing the consecutively identical characters, replace them with a
     * single character that comes before it alphabetically.
     * @param input
     */

    @Override
    List<String> dealWithInput(String input) {
        ArrayList<String> resultList = new ArrayList<>();

        if(input == null || input.isEmpty() || !isAllLowerCase(input)){
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
                resultList.add(input);
                break;
            }
            char previousLetter = getPreviousLetter(input.charAt(consecutiveRange[0]));
            StringBuilder outputB = new StringBuilder(input.substring(0, consecutiveRange[0])).append(previousLetter).append(input.substring(consecutiveRange[1] + 1, input.length()));
            StringBuilder outputStr = new StringBuilder(outputB).append(",").append(input.substring(consecutiveRange[0], consecutiveRange[1] + 1)).append(" is replaced by ").append(previousLetter);
            resultList.add(outputStr.toString());
            input = outputB.toString();
        }
        return resultList;

    }
}
