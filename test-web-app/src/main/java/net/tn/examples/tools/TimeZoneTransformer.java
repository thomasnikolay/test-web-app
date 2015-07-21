/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.tools;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author tnikolay
 */
public class TimeZoneTransformer {
    
    public static void main(String[] args) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        Date today = new Date();
        TimeZone tz = TimeZone.getTimeZone("GMT-7");
        df.setTimeZone(tz);
        
        System.out.println(df.format(today));
    }
    
}
