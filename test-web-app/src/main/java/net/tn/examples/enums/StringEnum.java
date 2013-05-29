/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.enums;

/**
 *
 * @author tnikolay
 */
public enum StringEnum {
    
    
    TEST;
    
    private String name;
    
    StringEnum(){
        this.name = name()+"x";
    }
    
    public String getName(){
        return name;
    }
            
}
