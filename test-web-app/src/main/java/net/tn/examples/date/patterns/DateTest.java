/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.date.patterns;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author tnikolay
 */
public class DateTest {
    public static void main(String[] args) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2002, Calendar.JANUARY, 8, 17,0, 0);
        System.out.println(gregorianCalendar.getTime().getTime());
    }
}
