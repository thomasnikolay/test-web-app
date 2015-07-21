/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.exmaples.utf8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author tnikolay
 */
public class NewClass {

    public static void main(String[] args) throws IOException {
        
        
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        FileOutputStream fout = new FileOutputStream(new File("D:\\test.tmp.txt"));
        
        for (int i=0; i < 65000; i++) {                                   
            out.println(Integer.toHexString(i) + " " + (char) i);                  
            fout.write(i);
        }
        fout.close();
    }

}
