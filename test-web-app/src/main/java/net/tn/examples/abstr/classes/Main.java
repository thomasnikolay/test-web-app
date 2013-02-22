/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.abstr.classes;

/**
 *
 * @author tnikolay
 */
public class Main {

    public static void main(String[] args) {
        realClass rc = new realClass();
        System.out.println(realClass.tueDies());
        System.out.println(Abstract.tueDies());
        System.out.println(rc.tueSonstwas());
        Abstract[] absArray = {new realClass(), new secondRealClass()};
    }
}
