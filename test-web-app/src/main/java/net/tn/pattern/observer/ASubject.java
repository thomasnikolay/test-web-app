/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public abstract class ASubject<E> {
    
    private List<IObserver> observers = new ArrayList<IObserver>();
    
    public void addNewObserver(IObserver<E> observer){
        observers.add(observer);                
    }

    public void dispatchHit(E e){
        for (IObserver iObserver : observers) {
            iObserver.receiveMessage(e);
        }
    }    
    
}
