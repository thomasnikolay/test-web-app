/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.enums;

import java.util.Random;

/**
 *
 * @author tnikolay
 */
public enum WeekDays {

    Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag, Sonntag;

    public static WeekDays getARandomWeekDay() {

        Random test = new Random();
        int aInt = test.nextInt(6);
        System.out.println(aInt);
        switch (aInt) {
            case 0:
                return WeekDays.Montag;
            case 1:
                return WeekDays.Dienstag;
            case 2:
                return WeekDays.Mittwoch;
            case 3:
                return WeekDays.Donnerstag;
            case 4:
                return WeekDays.Freitag;
            case 5:
                return WeekDays.Samstag;
            case 6:
                return WeekDays.Sonntag;
            default:
                return WeekDays.Freitag;
        }
    }
}
