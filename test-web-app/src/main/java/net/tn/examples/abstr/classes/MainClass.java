/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.abstr.classes;

/**
 *
 * @author tnikolay
 */
public class MainClass {
    public static void main(String[] args) {
        abstractHouse test = new coastHouse();
        System.out.println(test.test());
    }

}
