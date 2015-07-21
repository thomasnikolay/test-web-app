/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.iterator.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 *
 * @author tnikolay
 */
public class IteratorForever {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        

        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey()+":"+entry.getValue());
        });
    }

}
