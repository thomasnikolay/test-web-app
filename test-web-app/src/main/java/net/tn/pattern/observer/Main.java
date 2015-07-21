/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.patterns.observer;

/**
 *
 * @author tnikolay
 */
public class Main {
    public static void main(String[] args) {
        
    
    HitDispatcher dispatcher = new HitDispatcher();
    dispatcher.addNewObserver(new IAm());
    dispatcher.dispatchHit(new Hit());
            }
}
