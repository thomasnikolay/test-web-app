/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public class ListTest {
    
    public static void main(String[] args) {
        List<String> test = new ArrayList<String>();
        test.add(null);
        
        System.out.println(test.get(0));
        
        if(null instanceof Object){
            System.out.println("Test1");
        }else{
            System.out.println("Test2");
        }
        
    }
    
}
