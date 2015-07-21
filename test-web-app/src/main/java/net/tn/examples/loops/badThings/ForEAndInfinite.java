/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.loops.badThings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public class ForEAndInfinite {

    public static void main(String[] args) {

        List<List<String>> list = new ArrayList<>();

        list.add(new ArrayList<String>() {
            {
                add("Test1");
                add("Test2");
            }
        });                

        for (String string : list.get(0)) {
            System.out.println(string);
            list = new ArrayList<>();
            list.add(new ArrayList<String>() {
            {
                add("Test3");
                add("Test4");
            }
        });
        }
        
        HashSet<String> test = new HashSet<>();
        test.add("juhu");
        test.contains(test);

    }
}
