/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.maps;

import java.util.Arrays;
import java.util.Collection;
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
        try {
          Thread.sleep(101);
        }
        catch(InterruptedException e) {
          
        }
        
        Map<String, String> test2 = new HashMap<>();
        
        for (Map.Entry<String, String> entry : test2.entrySet()) {
            String string = entry.getKey();
            String string1 = entry.getValue();
            
        }
        
        Collection<String> myList = Arrays.asList("Hello","Java");
        long countLongStrings = myList.stream().filter(element -> element.length() > 4).count();
        
        
        
    }
}
