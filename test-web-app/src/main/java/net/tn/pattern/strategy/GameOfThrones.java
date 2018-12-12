/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.pattern.strategy;

/**
 *
 * @author tnikolay
 */
public class GameOfThrones {
    public static void main(String[] args) {
        Enemy dragon = new Dragon();
        dragon.hit();
        dragon.move();
        dragon.setHitBehavior(new IHitBehavior() {

            @Override
            public void hit() {
                System.out.println("angry Dragon - you are dead");
            }
        });
        dragon.hit();
    }
}
