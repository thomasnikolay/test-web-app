/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.inheritance.polymorphie;

/**
 *
 * @author tnikolay
 */
public class C {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a = b;
        a.print();
    }
    
}
