/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.threadlocal;

/**
 *
 * @author tnikolay
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        final StupidService stupidService = new StupidService();
        new Thread(new Runnable() {

            @Override
            public void run() {
         stupidService.printState("Yerah");
            }
        }).start();
        Thread.sleep(1000);
        
        new Thread(new Runnable() {

            @Override
            public void run() {
         stupidService.printState(null);
            }
        }).start();
    }
}
