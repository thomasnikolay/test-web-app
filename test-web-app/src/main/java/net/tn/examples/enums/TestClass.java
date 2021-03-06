package net.tn.examples.enums;

/**
 *
 * @author tnikolay
 */
public class TestClass {

    public static void main(String[] args) {
        WeekDays wd = null;
        try {
            wd = WeekDays.valueOf("Montag");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler in der Zuweisung!");
        }

        if (wd != null) {
            switch (wd) {
                case Dienstag:
                    System.out.println(WeekDays.Dienstag);
                    break;
                case Mittwoch:
                    System.out.println(WeekDays.Mittwoch);
                    break;
                case Montag:
                    System.out.println(WeekDays.Montag);
                    break;
                default:
                    System.out.println("Default");
                    break;
            }
        } else {
            System.out.println("Ende");
        }

        for (int i = 0, j = 1; i<1000;i++, j++ ){
        System.out.println(j + ". Mister Zufall sagt: " + WeekDays.getARandomWeekDay().name());
        }
    }
}
