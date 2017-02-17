/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.locking;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author tnikolay
 */
public class SyncInheritage {

    public synchronized void printSome() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(StringUtils.repeat("x", i));
        }
    }

    public static void main(String[] args) {
        SyncInheritageChildA test = new SyncInheritageChildA();
        SyncInheritageChildB test2 = new SyncInheritageChildB();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    test.printSome();
                    test2.printSome();
                }
            }).start();
        }
    }

}
