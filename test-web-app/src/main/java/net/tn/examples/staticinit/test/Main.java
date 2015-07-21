/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.staticinit.test;

/**
 *
 * @author tnikolay
 */
public class Main {
    public static void main(String[] args) {
        StaticClass staticClass = StaticClass.getInstance(Main.class.getClassLoader());
        System.out.println(staticClass);
    }
}
