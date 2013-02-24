/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.tools.cron.tester;

import java.util.HashMap;

/**
 *
 * @author tnikolay
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, String> strStr = new HashMap<String, String>();
        strStr.put("some", "some text");
        System.out.println(strStr.remove("some"));
        System.out.println(strStr.remove("some"));
    }
    
}
