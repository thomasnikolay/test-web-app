/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.abstr.classes;

/**
 *
 * @author tnikolay
 */
public abstract class abstractHouse {

    protected String housename="";

    public abstract int calculateSquareMeter();
    public abstract int housenumber();
    public String test(){
        return "test";
    }

}
