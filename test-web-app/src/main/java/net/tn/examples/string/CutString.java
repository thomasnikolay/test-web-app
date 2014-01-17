/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.string;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author tnikolay
 */
public class CutString {
    public static void main(String[] args) {
        try{
            //bad
            System.out.println("Thomas".substring(0, 50));        
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //very good
        System.out.println(StringUtils.substring("0123456789A", 0, 10));
    }
    
}
