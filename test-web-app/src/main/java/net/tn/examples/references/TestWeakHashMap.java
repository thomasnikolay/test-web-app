/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.references;

import java.util.Map;
import java.util.WeakHashMap;

/**
 *
 * @author tnikolay
 */
public class TestWeakHashMap {
    public static void main(String[] args) {
        Map<String, String> test = new WeakHashMap<>();
        // "strong" is a Strong reference in this class
        // new String("weak") ist a weak reference        
        test.put(new String("Feuer"), "Feuer");
        
        System.gc();
        System.gc();
        System.gc();
        System.out.println(test.containsKey("Feuer"));
        
    }
    
}
