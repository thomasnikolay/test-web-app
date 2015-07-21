/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.examples.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author tnikolay
 */
public class GregorianCalendarTest {
    
    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar(2015, Calendar.MARCH, 31);
        System.out.println(cal.getTime().toString());
        
    }
    
}
