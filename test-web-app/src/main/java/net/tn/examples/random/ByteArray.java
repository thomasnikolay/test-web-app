/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.random;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tnikolay
 */
public class ByteArray {

    public static void main(String[] args) {
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        try {
            for (int i = 0; i < 50; i++) {
                test.write(new byte[1024]);
            }
        } catch (IOException ex) {
            Logger.getLogger(ByteArray.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] test2 = test.toByteArray();
        new Random().nextBytes(test2);
        new Random(System.currentTimeMillis()).nextBytes(test2);
        System.out.println(new String(test2));
    }
}
