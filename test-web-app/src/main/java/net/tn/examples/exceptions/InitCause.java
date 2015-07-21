/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.exceptions;

/**
 *
 * @author tnikolay
 */
public class InitCause {
    
    public static void main(String[] args) throws Exception{
        try{
        try{
            throw new Exception("some Bullshit");
        }catch(Exception ex){
            try{
                throw new Exception("outside");
            }catch(Exception e){
                e.initCause(ex);
                throw e;
            }
        }
     }catch(Exception ex){
         ex.printStackTrace();
         
     }   
        
    }
    
}
