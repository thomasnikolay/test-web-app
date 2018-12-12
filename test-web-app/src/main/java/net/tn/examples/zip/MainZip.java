/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.zip;

import java.io.IOException;
import java.net.Socket;
import java.util.Base64;
import java.util.zip.Inflater;

/**
 *
 * @author Thomas
 */
public class MainZip {
 
    public static void main(String[] args) throws IOException {

        try {
            // Encode a String into bytes
            String output1 = "w4tIw43DicOJL8OPL8OKSQEA";

            byte[] output2;
            output2 = Base64.getDecoder().decode(output1);

            // Decompress the bytes
            Inflater decompresser = new Inflater();
            decompresser.setInput(output2);
            
            Socket socket = new Socket("localhost", 9292);

            System.out.println("a:" + new String(output2));

            byte[] result = new byte[100];
            int resultLength = decompresser.inflate(result);
            decompresser.end();

            // Decode the bytes into a String
            String outputString = new String(result, 0, resultLength, "UTF-8");
            System.out.println("b:" + outputString);

        } catch (java.io.UnsupportedEncodingException ex) {
            ex.printStackTrace();
            // handle
        } catch (java.util.zip.DataFormatException ex) {
            ex.printStackTrace();
            // handle
        }

    }
    
}
