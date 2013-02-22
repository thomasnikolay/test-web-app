/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

/**
 *
 * @author tnikolay
 */
public class Base64Example {
    public static void main(String[] args) throws Exception {
        String inputDirectory = "C:\\Users\\tnikolay\\Desktop\\CBS News\\MOBILE FONTS\\MOBILE FONTS\\Georgia\\";
        String inputFile = "Georgia Regular.TTF";
        
        System.out.println("transcode "+ inputDirectory + inputFile +" to base64");
        String base64 = new BASE64Encoder().encode(IOUtils.toByteArray(new FileInputStream(new File(inputDirectory+inputFile))));
        
        base64 = base64.replaceAll("\n\r", "");
        base64 = base64.replaceAll("\n", "");
        base64 = base64.replaceAll("\r", "");
                
        OutputStream out = new FileOutputStream(new File(inputDirectory+inputFile+".base64.txt"));        
        out.write(base64.getBytes());
        System.out.println("finished"+base64);
    }
}
