/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;


/**
 *
 * @author tnikolay
 */
public class Base64Example {
    public static void main(String[] args) throws Exception {
        String inputDirectory = "C:\\Users\\tnikolay\\Desktop\\CBS News\\MOBILE FONTS\\MOBILE FONTS\\Georgia\\";
        String inputFile = "Georgia Regular.TTF";
        
        System.out.println("transcode "+ inputDirectory + inputFile +" to base64");
        Base64 base64 = new Base64();        
        String base64Encoded = new String(base64.encode(IOUtils.toByteArray(new FileInputStream(new File(inputDirectory+inputFile)))));
        
        base64Encoded = base64Encoded.replaceAll("\n\r", "").replaceAll("\n", "").replaceAll("\r", "");

                
        OutputStream out = new FileOutputStream(new File(inputDirectory+inputFile+".base64.txt"));        
        out.write(base64Encoded.getBytes());
        System.out.println("finished"+base64);
        out.close();
    }
}
