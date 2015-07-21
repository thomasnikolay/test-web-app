/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.exmaples.evil;

import java.lang.management.MemoryUsage;
import sun.misc.Unsafe;

/**
 *
 * @author tnikolay
 */
public class UnsafeTest {
    
    public static void main(String[] args) throws InterruptedException {        
        Unsafe unsafe = Unsafe.getUnsafe();
        sun.misc.VM.
        unsafe.allocateMemory(50000);
        
        Thread.sleep(100000L);
        
    }
    
}
