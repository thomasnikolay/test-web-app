/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.array.things;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public class RemoveNullValues {

    public static void main(String[] args) {
        String[] input = {"Luke", null, null, "Leah", null, "Anakin"};
        
        ArrayList<String> test = new ArrayList<>(Arrays.asList(input));                
        
        test.removeAll(Collections.singleton(null));
        String[] toArray = test.toArray(new String[test.size()]);
        
        for (String string : toArray) {
            System.out.println(string);
        }

    }
}
