/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.examples.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Thomas Nikolay
 */
public class ATest2 {
    int val = 10;
    int x;
    ATest2(int i){
        val=i;
    }
    
    private AtomicInteger value = new AtomicInteger(val);
    
    public static void main(String[] args) {
        ATest2 at = new ATest2(5);
        System.out.println(at.value.decrementAndGet());
    }
}
