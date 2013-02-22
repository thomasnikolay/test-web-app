/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.abstr.classes;

/**
 *
 * @author tnikolay
 */
public class coastHouse extends abstractHouse{

    @Override
    public int calculateSquareMeter() {
        return 5;
    }

    @Override
    public int housenumber() {
        return Integer.valueOf(super.housename);
    }

    @Override
    public String test(){
        return super.test()+"test";
    }

}
