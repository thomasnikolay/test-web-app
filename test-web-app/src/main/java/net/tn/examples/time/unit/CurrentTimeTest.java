/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.time.unit;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author tnikolay
 */
public class CurrentTimeTest {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        for (int i=0; i < 10; i++) {
            
            System.out.println(System.nanoTime());
        }
        
        final Date date = new Date();
        final Timestamp timestamp = new Timestamp(date.getTime());
        
        System.out.println(timestamp.getNanos());
    }

}
