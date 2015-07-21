/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.switchtest;

/**
 *
 * @author tnikolay
 */
public class SwitchTest {

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;

        switch (i) {
            case 4:
                System.out.println("4");
            case 3:
                System.out.println("3");
            case 2:
                System.out.println("2");
            case 1:
                System.out.println("1");
            default: System.out.println("damned");
        }

    }

}
