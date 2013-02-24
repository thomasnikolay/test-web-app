/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.enums;

/**
 *
 * @author tnikolay
 */
public class EnumTest {
    public static void main(String[] args) {
        WeekDays wd=null;
        try{
        wd = WeekDays.valueOf(null);
        }catch(IllegalArgumentException e){
            System.out.println("Fehler in der Zuweisung!");
        }

        if(wd!=null){
        switch(wd){
            case Dienstag:System.out.println(WeekDays.Dienstag);
            break;
            case Mittwoch:System.out.println(WeekDays.Mittwoch);
            break;
            case Montag:System.out.println(WeekDays.Montag);
            break;
            default:System.out.println("Default");
            break;
        }
        }else{
            System.out.println("Ende");
        }

        System.out.println("Mister Zufall sagt: "+ WeekDays.getARandomWeekDay().name());
    }


}
