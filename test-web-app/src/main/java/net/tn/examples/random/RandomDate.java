/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.random;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author tnikolay
 */
public class RandomDate {

    public static void main(String[] args) {
        
        for (int i = 0; i < 500; i++) {
            Random rand = new Random();
            int min = -5, max = 365;
            int randomNum = rand.nextInt(max - min + 1) + min;
            Calendar cal = new GregorianCalendar();
            cal.add(Calendar.DAY_OF_MONTH, randomNum);
            System.out.println(new SimpleDateFormat("dd.MM.yyyy").format(new Date(cal.getTimeInMillis())));

        }

    }

}
