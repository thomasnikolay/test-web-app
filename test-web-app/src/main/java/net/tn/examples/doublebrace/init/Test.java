/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.doublebrace.init;

import java.util.ArrayList;

/**
 *
 * @author tnikolay
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<String>(){{
            add("Test");
            add("Test2");
        }};
        
        System.out.println(test);
    }
    
}
