/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.patterns.observer;

/**
 *
 * @author tnikolay
 * @param <E>
 */
public interface IObserver<E> {
    public void receiveMessage(E object);
}
