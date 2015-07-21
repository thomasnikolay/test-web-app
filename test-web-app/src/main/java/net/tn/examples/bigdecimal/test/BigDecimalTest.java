/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.bigdecimal.test;

import java.math.BigDecimal;

/**
 *
 * @author tnikolay
 */
public class BigDecimalTest {
    
    public static void main(String[] args) {
        
        BigDecimal test1 = new BigDecimal("0");
        BigDecimal test2 = new BigDecimal("0.10");
        
        System.out.println(test1.signum() == 0);
        System.out.println(test2.signum() == 0);
        
    }
    
}
