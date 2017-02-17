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
public class TestExecption {
    
    public static void main(String[] args) {
        
        try{
            throw new Exception();
        }catch(IllegalArgumentException ex){
            System.out.println("1");
        } catch (Exception e){
            System.out.println("2");
        }
        
        
    }
    
}
