/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.examples.inheritance.statictest;


/**
 *
 * @author tnikolay
 */
public class Main {
    public static void main(String[] args) {
        ASuperClass a = new ImplementationA();
        ASuperClass b = new ImplementationB();
        
        a.puto("testA", "testA");
        b.puto("testB", "testB");
        
        a.put("Josh", "Radnor");
        b.put("Cobbie", "Smulders");
        
        System.out.println("static output");
        ASuperClass.printAll();
        System.out.println("object output");
        a.printo();
        b.printo();
    }
}
