/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.examples.inheritance.visibility.b;

import net.examples.inheritance.visibility.a.Parent;

/**
 *
 * @author tnikolay
 */
public class Child extends Parent{
    public static void main(String[] args) {
        Child c = new Child();
        c.publicMethod();
        c.protectedMethod();
    }
}
