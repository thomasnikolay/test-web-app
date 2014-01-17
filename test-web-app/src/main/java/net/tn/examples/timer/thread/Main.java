/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.timer.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author tnikolay
 */
public class Main {

    private static URL url = null;

    static {
        try {
            url = new URL("https://apps.netbiscuits.com/195634/Admin/golive.do");
            java.lang.System.setOut(new PrintStream(new FileOutputStream(new File("c:\\test-hau-mich-blau-2.log"))));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                printSpacer(System.out, false);
                URLConnection urlc;
                try {
                    urlc = url.openConnection();
                    urlc.connect();
                    InputStream is = urlc.getInputStream();
                    for (Map.Entry<String, List<String>> entry : urlc.getHeaderFields().entrySet()) {
                        System.out.println(entry.getKey() + " = " + entry.getValue());
                    }
                    System.out.println(IOUtils.toString(is));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                printSpacer(System.out, true);
            }
        }, 3000, 5000);
    }

    static void printSpacer(PrintStream ps, boolean printCr) {
        for (int i = 0; i < 100; i++) {
            ps.print("*");
        }
        ps.print("\n");
        if (printCr) {
            ps.print("\n");
        }

    }
}
