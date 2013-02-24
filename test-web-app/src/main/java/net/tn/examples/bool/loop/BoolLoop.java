package net.tn.examples.bool.loop;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tnikolay
 */
public class BoolLoop {

    public static void main(String[] args) {
        String[] stringArray = {"montag", "dienstag", "mittwoch", "donnerstag"};

        for (String string : stringArray) {
            System.out.println(string);
        }

        WrapperTest[] test = {new WrapperTest(true), new WrapperTest(true), new WrapperTest(false)};

        for (boolean a = test[0].wert; a; a = test[1].wert) {
        }
    }

    static class WrapperTest {

        boolean wert;

        public WrapperTest(boolean wert) {
            this.wert = wert;
        }
    }
}
