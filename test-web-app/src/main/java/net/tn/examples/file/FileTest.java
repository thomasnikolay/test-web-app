/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.file;

import java.io.File;

/**
 *
 * @author tnikolay
 */
public class FileTest {
    
    public static void main(String[] args) {
        File file = new File("d:/temp.dat");       
        file.createNewFile();
        System.out.println(file.exists());
    }
    
}
