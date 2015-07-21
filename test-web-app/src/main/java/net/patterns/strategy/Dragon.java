/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.patterns.strategy;

/**
 *
 * @author tnikolay
 */
public class Dragon extends Enemy{

    public Dragon() {
        this.setHitBehavior(new CriticalHit());
        this.setMoveBehavior(new MoveFly());
    }
    
}
