/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.abstr.classes;

/**
 *
 * @author tnikolay
 */
public class MainTop {

    
    public static void main(String[] args) {
        AbstractTop test1 = new TestAbstract();
        AbstractTop test2 = new TestAbstract2();
        System.out.println(test1.test);
        System.out.println(test2.test);
        System.out.println(test1.test);
    }
    
}
