/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tnikolay
 */
public class DateValidator {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        
        String year=null, month=null, day=null, time=null;
        
        
        try {
            
            System.out.println(df.parse(year + month + day +time));
        } catch (ParseException ex) {
            Logger.getLogger(DateValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
