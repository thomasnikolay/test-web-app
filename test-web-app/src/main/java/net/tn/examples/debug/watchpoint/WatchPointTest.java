/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.debug.watchpoint;

/**
 *
 * @author tnikolay
 */
public class WatchPointTest {
    
    public static void main(String[] args) {
        String test = null;
        
        for(int i =0; i< 100; i++){                    
        System.out.println(i);
        
        if(i == 50){
            test = "stop";
        }
        }
        
        int i = 0;
        int j = 2048;
        int x = 512;
        
        System.out.println(i|j|x);
        
    }
    
}
