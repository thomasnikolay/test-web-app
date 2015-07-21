/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author tnikolay
 */
public class NotAvaFileRename {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        File testFile = new File("D:\\not_existing_file");
                        OutputStream os = new FileOutputStream(testFile);
                        os.write("some_bullshit".getBytes());
                        os.close();

                        File testDestFile = new File("D:\\unbelievable\\not_existing_dest_file");

                        System.out.println(testFile.renameTo(testDestFile));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
                .start();

        new Thread() {
            public void run() {
                while (true) {

                    File testFile = new File("D:");
                    testFile.listFiles();

                    for (File file : testFile.listFiles()) {
                        System.out.println(file.getName());
                    }

                }
            }
        }
                .start();

    }

}
