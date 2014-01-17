/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.regex;

/**
 *
 * @author tnikolay
 */
public class RegexMatcherTester {
    
    public static void main(String[] args) {
        String pattern = "\\d{9}";
        String string = "123456789";
        System.out.println(string.matches(pattern));
    }
}