/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.random;

import java.util.Random;

/**
 *
 * @author tnikolay
 */
public class RandomInteger {

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(new Random(i).nextInt(10));

        }
    }

}
