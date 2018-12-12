/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.pattern.observer;

/**
 *
 * @author tnikolay
 */
public class IAm implements IObserver<Hit>{

    @Override
    public void receiveMessage(Hit hit) {
        System.out.println("autsch "+hit.toString());
    }
    
}
