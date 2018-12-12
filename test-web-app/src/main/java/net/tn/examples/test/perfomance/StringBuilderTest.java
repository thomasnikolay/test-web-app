/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.test.perfomance;

/**
 *
 * @author tnikolay
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long testStrings = 1000;
        
        String test = "test - - - -";
        for (int i = 0; i < testStrings; i++) {
            test += "test - - - -";
        }
        long mid = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder("test - - - -");
        for (int i = 0; i < testStrings; i++) {
            sb.append("test - - - -");
        }
        long end = System.currentTimeMillis();
        System.out.println("time for concat = "+(mid-start)+"ms");
        System.out.println("time for StringBuilder = "+(end-mid)+"ms");
        System.out.println(test);
    }
}
