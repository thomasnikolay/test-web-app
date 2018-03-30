/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public class Test {
    
    public static void main(String[] args) {
        List<Parent> a = new ArrayList<>();
        List<? super Parent> leftSublist = leftSublist();
        
        leftSublist.add(new Child());
        
    }
    
    public static List<? super Parent> leftSublist( ){
        return null;
        
    }
    
}
