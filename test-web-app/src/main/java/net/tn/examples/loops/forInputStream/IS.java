/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.loops.forInputStream;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author tnikolay
 */
public class IS {
    private static String loadSomeText() {
        URL url;
        try {
            url = new URL("http://www.spiegel.de");
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();

            for (int i = is.read(); i != -1; i = is.read()) {
                System.out.print((char) i);
            }

        } catch (Exception ex) {
            System.err.println("can not connect");
        }
        return "";
    }
    
    public static void main(String[] args) {
        loadSomeText();
    }
}
