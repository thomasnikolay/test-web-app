/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.exmaples.wrapper;

/**
 *
 * @author tnikolay
 */
public class IntegerTest {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.BYTES);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.TYPE);
                
        
        System.out.println(Integer.MIN_VALUE+10);
        
        System.out.println(10 < Integer.MIN_VALUE);
   
        
        System.out.println(Integer.rotateLeft(0, 1));
        System.out.println(Integer.rotateLeft(1, 1));
        System.out.println(Integer.rotateLeft(1, 2));
        System.out.println(Integer.rotateLeft(1, 3));
        
         
    }
}
