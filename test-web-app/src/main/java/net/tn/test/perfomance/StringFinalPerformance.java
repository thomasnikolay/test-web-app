package net.tn.test.perfomance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class StringFinalPerformance {

    final static String TEST_PARAM_NAME = "testParam";
    final static String TEST_PARAM_NAME_1 = "testParam";
    final static String TEST_PARAM_NAME_2 = "testParam";
    final static String TEST_PARAM_NAME_3 = "testParam";
    final static String TEST_PARAM_NAME_4 = "testParam";
    final static String TEST_PARAM_NAME_5 = "testParam";

    private void bullshit() {
        String parameterValue = " ";
        if ("value1".equals(parameterValue)) {
            //to do 1
        } else if ("value2".equals(parameterValue)) {
            //to do 2
        } else if ("value3".equals(parameterValue)) {
            //to do 3
        } else if ("value4".equals(parameterValue)) {
            //to do 4
        } else if ("value5".equals(parameterValue)) {
            //to do 5
        }
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("value1");
        list.add("value2");
        list.add("value3");

        String result = "";
        
       Set<String> set = new HashSet<String>();
       set.addAll(list);
        
    }
}
