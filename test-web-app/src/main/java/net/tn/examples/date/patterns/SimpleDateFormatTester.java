/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.date.patterns;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author tnikolay
 */
public class SimpleDateFormatTester {

    public static void main(String[] args) {
        String exampleDate = "2013-05-07@14:47:05 CET";
        String inputPattern = "yyyy-MM-dd'@'HH:mm:ss z";
        String outputPattern = "EEE',' dd MMM yyyy HH:mm:ss z";
        
        SimpleDateFormat sdf = new SimpleDateFormat(inputPattern, Locale.ENGLISH);
        SimpleDateFormat odf = new SimpleDateFormat(outputPattern,Locale.ENGLISH);
        try {
            Date date = sdf.parse(exampleDate);
            System.out.println("input: " + date.toString());
            System.out.println("output: " + odf.format(date).toString());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }
}
