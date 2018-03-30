/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.threadlocal;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author tnikolay
 */
public class StupidService {
    
    ThreadLocal<String> test = new ThreadLocal<>();
    
    public void printState(String str){
        if(StringUtils.isNotEmpty(str)){
            test.set(str);    
        }       
        System.out.println(test.get());
    }
    
}
