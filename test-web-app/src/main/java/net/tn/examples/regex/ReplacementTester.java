/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tnikolay
 */
public class ReplacementTester {
    public static void main(String[] args) {
        String testValue = "/at/index.jsp";
        Pattern pattern = Pattern.compile("^/(de|at)/(.*)");
        Matcher m = pattern.matcher(testValue);
        
        while(m.find()){
            String result = m.group(1);
            System.out.println("http://www.smart."+result);
        }
    }
}
