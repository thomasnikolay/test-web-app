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
        String testValue = "zapo-phillip";
        Pattern pattern = Pattern.compile(".*zip");
        Matcher m = pattern.matcher(testValue);
        
        System.out.println(m.matches());
    }
}
