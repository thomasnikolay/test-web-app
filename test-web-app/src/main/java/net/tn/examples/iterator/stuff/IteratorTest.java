/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.iterator.stuff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tnikolay
 */
public class IteratorTest {
    public static void main(String[] args) {
        
        Set<String> set = new HashSet<String>();
        set.add("Jippie");
        set.add("Super");
        set.add("Karl");
        Iterator<String> iterator = set.iterator();
        Iterator<String> iterator2 = set.iterator();

        
        while(iterator.hasNext()){
        System.out.println(iterator.next());
        }
        
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        
        
    }
    
}
