/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.jms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author tnikolay
 */
public class RealySerializable {

    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("c:\\object.output")));
            oos.writeObject(new Serializable() {
            });
        } finally {
            if (oos != null) {
                oos.flush();
                oos.close();
            }
        }
    }
}
