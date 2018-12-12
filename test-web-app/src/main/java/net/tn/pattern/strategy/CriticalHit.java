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
public class CriticalHit implements IHitBehavior{

    @Override
    public void hit() {
        System.out.println("Critical HIT! Bamm!");
    }
    
    
}
