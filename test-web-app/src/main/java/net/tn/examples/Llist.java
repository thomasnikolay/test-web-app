/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author tnikolay
 */
public class Llist {

    public static void main(String[] args) {

        ArrayList testList = new ArrayList();
        testList.add("Super");
        testList.add("DUPER");
        testList.add("FLUPPER");
        testList.add("DUPER");

//        for (int i = 0; testList != null && i < testList.size(); i++) {
//            String state = (String) testList.get(i);
//
//            if (state.equalsIgnoreCase("DUPER")) {
//                testList.remove(i);
//                System.out.println("I removed");
//            }
//        }

        for (Iterator it = testList.iterator(); it != null && it.hasNext();) {
            if (it.next().equals("DUPER")) {
                it.remove();
            }
        }
        
        for (Object object : testList) {
            System.out.println(object);
        }
        
        "".isEmpty();
        
        
    }

}
