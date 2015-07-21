/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.fileutils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author tnikolay
 */
public class FileUtilsTest {
    
    public static void main(String[] args) throws IOException {
        
        InputStream toInputStream = IOUtils.toInputStream("Krass");
        
        FileUtils.copyInputStreamToFile(toInputStream, new File("D:\\test.zip"));
        
    }
    
}
