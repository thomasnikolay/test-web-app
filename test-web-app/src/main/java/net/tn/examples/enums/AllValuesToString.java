/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.enums;

/**
 *
 * @author tnikolay
 */
public class AllValuesToString {
    
    public enum Test{
        TEST_1, Test2
    }
    
    public static void main(String[] args) {
        
        for (Test test : Test.values()) {
            System.out.println(test.toString());
        }
    }
}
