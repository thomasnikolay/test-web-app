/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.examples.inheritance.polymorphie.public_private_methods;

/**
 *
 * @author tnikolay
 */
public class Parent {
    
    public void printSomething(){
        printConcrete();
    }
    
    private void printConcrete(){
        System.out.println("konkret Parent");
    }
}
