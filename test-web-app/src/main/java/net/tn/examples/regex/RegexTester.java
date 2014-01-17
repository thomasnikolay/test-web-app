/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.regex;

/**
 *
 * @author tnikolay
 */
public class RegexTester {
    public static void main(String[] args) {
        
        String testString = "";
        String pattern = "(?s)<script.*/script>";
        System.out.println(testString.replaceAll(pattern, ""));
    }
   
}
