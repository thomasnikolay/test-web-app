/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author tnikolay
 */
public class SystemExecutionTest {

    public static void main(String[] args) throws IOException {

        Process p = Runtime.getRuntime().exec("calc.exe dir");
        byte[] buffer = new byte[10000];
        InputStream inputStream = p.getInputStream();
        while (true) {
            int amountRead = inputStream.read(buffer);
            if (amountRead == -1) {
                break;
            }
            System.out.write(buffer, 0, amountRead);
        }        
    }

}
