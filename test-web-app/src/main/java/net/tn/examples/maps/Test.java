/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.maps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tnikolay
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> test = new HashMap<>();
        test.put("lol", null);
        System.out.println(test.get("lol"));
        System.out.println(test.containsKey("lol"));
    }
}
