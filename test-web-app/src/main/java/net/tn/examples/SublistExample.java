/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public class SublistExample {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Thomas");
        list.add("Jochen");
        
        List<String> subList = list.subList(0, 1);
        
        System.out.println(subList);
        
    }
    
}
