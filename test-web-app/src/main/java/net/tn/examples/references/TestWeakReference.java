/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.references;

import java.lang.ref.WeakReference;

/**
 *
 * @author tnikolay
 */
public class TestWeakReference {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<String> r = new WeakReference<>(new String("test"));
        WeakReference<String> sr = new WeakReference<>("strong reference why?");
        
        
        
            System.out.println("before gc: r=" + r.get() + ", static=" + sr.get());
            System.gc();
            Thread.sleep(100);
 
            // only r.get() becomes null
            System.out.println("after gc: r=" + r.get() + ", static=" + sr.get());
        
    }
    
}
