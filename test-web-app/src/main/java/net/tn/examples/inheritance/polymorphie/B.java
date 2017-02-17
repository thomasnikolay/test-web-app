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
public class B extends A{
    
    private String string;

    @Override
    public void print() {
        System.out.println(string);
        
        super.print();
    }

    @Override
    public void setString(String string) {
        this.string = string;
        super.setString(string); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
