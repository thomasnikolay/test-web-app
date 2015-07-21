/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.generics;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tnikolay
 */
public class GenericTest {
    public static void main(String[] args) {
        Map<String, ? extends Number> test = new HashMap<String, Integer>();
        test.put("test", null);
    }
}
