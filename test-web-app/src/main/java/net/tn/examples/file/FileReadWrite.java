/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.file;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author tnikolay
 */
public class FileReadWrite {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\test.txt");
        file.createNewFile();
        file.setWritable(false);
        System.out.println("canWrite: "+file.canWrite());
        file.setWritable(true);
        System.out.println("canWrite: "+file.canWrite());
        
    }
}
