/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author tnikolay
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar myBirthday = new GregorianCalendar(1984, 3, 12);
        Calendar now = Calendar.getInstance();
        System.out.println(now.after(myBirthday));
    }
    
}
