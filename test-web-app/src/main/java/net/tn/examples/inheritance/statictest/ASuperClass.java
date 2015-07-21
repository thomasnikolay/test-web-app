/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.inheritance.statictest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tnikolay
 */
public abstract class ASuperClass {
    
    private static Map<String, String> cache = new HashMap<String,String>();
    
    private Map<String, String> cacheo = new HashMap<String,String>();
    
    
    public static void put(String key, String value){
        cache.put(key, value);
    }
    
    public static String get(String key){
        return cache.get(key);
    }
    
    public static void  printAll(){
       System.out.println(cache.toString());
    }
    
    public void puto(String key, String value){
      cacheo.put(key, value);      
    }
    
    public String geto(String key){
      return cacheo.get(key);
    }
    
    public void printo(){
      System.out.println(cacheo.toString());
    }
}
