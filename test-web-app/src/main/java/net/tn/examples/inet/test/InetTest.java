/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.inet.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author tnikolay
 */
public class InetTest {
    
    public static void main(String[] args) throws UnknownHostException {
        String adresse = InetAddress.getByName("gk-software.com").toString();
        System.out.println(adresse);
    }
    
}
