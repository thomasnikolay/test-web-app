/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.date.patterns;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tnikolay
 */
public class SimpleDateFormatTester {

    public static void main(String[] args) {
        String exampleDate = "03/12/1984";
        String inputPattern = "MM/dd/yyyy";        
        
        SimpleDateFormat sdf = new SimpleDateFormat(inputPattern);        
        try {
            Date date = sdf.parse(exampleDate);
            System.out.println("input: " + date.toString());            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }
}
