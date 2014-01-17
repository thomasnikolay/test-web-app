/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.exceptions;

import java.io.IOException;

/**
 *
 * @author tnikolay
 */
public class Sockets {

    public static void main(String[] args) {
        try {
            throw new java.net.SocketTimeoutException();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
