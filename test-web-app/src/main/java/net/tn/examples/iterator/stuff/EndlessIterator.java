/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.iterator.stuff;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public class EndlessIterator {
    public static void main(String[] args) {
        List<String> test = new ArrayList<String>();
        test.add("1");
        test.add("2");
        test.add("3");
        
        Iterable<String> cycle = Iterables.cycle(test);
        
        Iterator<String> iterator = cycle.iterator();
        
        int i = 0;
        
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            i++;
            
            if(i > 20){
                break;
            }
        }
    }
    
}
