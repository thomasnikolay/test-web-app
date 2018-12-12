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
public abstract class Enemy {
    
    IMoveBehavior moveBehavior = new MoveFly();
    IHitBehavior hitBehavior = new IHitBehavior() {

        @Override
        public void hit() {
            System.out.println("default hit");
        }
    };
    
    public void move(){
        moveBehavior.move();
    }
    
    public void hit(){
        hitBehavior.hit();
    }

    public IMoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(IMoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public IHitBehavior getHitBehavior() {
        return hitBehavior;
    }

    public void setHitBehavior(IHitBehavior hitBehavior) {
        this.hitBehavior = hitBehavior;
    }
    
    
    
}
