/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.enums;

/**
 *
 * @author tnikolay
 */
public class ConstantTest {
    public static void main(String[] args) {
        Constant test = Constant.ONLY_READ;
        System.out.println(test.isModifyAllowed());
    }
    
}
