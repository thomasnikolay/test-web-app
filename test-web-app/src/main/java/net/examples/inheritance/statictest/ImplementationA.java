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
public class ImplementationA extends ASuperClass{
    
    static {
        ASuperClass.put("TestA", "TestA");
    }

}
