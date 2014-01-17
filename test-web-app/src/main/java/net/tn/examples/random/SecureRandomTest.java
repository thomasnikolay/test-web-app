/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.random;

import java.security.SecureRandom;

/**
 *
 * @author tnikolay
 */
public class SecureRandomTest {
    public static void main(String[] args) {
        String serverName = System.getProperty("jboss.host.name")+ System.getProperty("jboss.server.name");
        SecureRandom srandom = new SecureRandom(serverName.getBytes());
        for (int i = 0; i < 100; i++) {
            System.out.println(srandom.nextInt(5000));
            
        }        
        
    }
}
