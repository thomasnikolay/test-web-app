/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.staticinit.test;

/**
 *
 * @author tnikolay
 */
public class StaticClass {
    private static ClassLoader classLoader = null;
    private static StaticClass instance = null;

    private StaticClass(ClassLoader classLoader1) {
        System.out.println(classLoader1);
    }
    
    public static StaticClass getInstance(ClassLoader classLoader1){
        StaticClass.classLoader = classLoader1;
        StaticClass.instance = new StaticClass(classLoader);
        return instance;
    }
}
