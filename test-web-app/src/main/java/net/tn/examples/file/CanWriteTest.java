/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author tnikolay
 */
public class CanWriteTest {

    public static void main(String[] args) throws IOException{
        try {
            final File testFile = new File("D:\\not_existing_file");
            OutputStream os = new FileOutputStream(testFile);
            os.write("some_bullshit".getBytes());            

            final File testDestFile = new File("D:\\unbelievable\\not_existing_dest_file");

            new Thread(){

                @Override
                public void run() {
                    final File testFile2 = new File("D:\\not_existing_file");
                    if(testFile2.canExecute()){
                    System.out.println(testFile2.renameTo(testDestFile));
                    }else{
                        System.out.println("can not write");
                    }
                }
                
            }.start();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
