/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.issues.actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author tnikolay
 */
public class Logger {
    static FileOutputStream fileout = null;
    static Logger logger = new Logger();
    
    static{
        File file = new File("C:\\temp\\logs\\SMART\\upload_proto.txt");
        try {
            fileout = new FileOutputStream(file, false);            
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
        
    }
    
    public static Logger getLogger(){
        return logger;
    }
    
    public static void info(String msg){
        if(fileout != null){
            try {
                fileout.write((msg+"\n").getBytes());
            } catch (IOException ex) {
                System.err.println(msg);
            }
        }else{
            System.out.println(msg);
        }
        
    }
    
    public static void severe(String msg){
        info(msg);
    }
    
}
