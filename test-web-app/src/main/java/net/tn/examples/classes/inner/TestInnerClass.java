/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.classes.inner;

/**
 *
 * @author tnikolay
 */
public class TestInnerClass {
    
    int ínt = 0;
    
    public static void main(String[] args) {
        Book harryPotter = new Book();
        
        harryPotter.setName("Harry Potter");
        Book.Page page = harryPotter.new Page();
        page.setNumber(1);
              
    }
    
}
