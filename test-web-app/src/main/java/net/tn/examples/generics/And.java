/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.generics;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author tnikolay
 */
public class And {

    public static void main(String[] args) {

    }

    public static <A, B extends Collection<A> & Comparable<B>>
            boolean foo(B b1, B b2, A a) {
        new Atomic
                
                return (b1.compareTo(b2) == 0) || b1.contains(a) || b2.contains(a);
        
    }
}
