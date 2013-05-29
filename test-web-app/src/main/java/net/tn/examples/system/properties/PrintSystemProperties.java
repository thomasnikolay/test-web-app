/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.system.properties;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tnikolay
 */
public class PrintSystemProperties {

    private static Map<String, String> systemProperties = new HashMap<>();
    public static void main(String[] args) {
        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
//            System.out.println(entry.getKey().toString()+" : "+ entry.getValue().toString());
            if (entry.getKey() instanceof String && entry.getValue() instanceof String) {
                systemProperties.put((String) entry.getKey(), (String) entry.getValue());
                
            }else{
                System.out.println("blöd");
            }
        }
        for (Map.Entry<String, String> entry : systemProperties.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
