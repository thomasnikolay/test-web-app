/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.locale;

import java.util.Locale;

/**
 *
 * @author tnikolay
 */
public class LocaleTest {
    public static void main(String[] args) {
        System.out.println("Test - 1");
        System.out.println(new Locale("en"));
        System.out.println("Test - 2");
        System.out.println(Locale.ENGLISH);
        System.out.println("Test - 3 ");        
        System.out.println(Locale.forLanguageTag("en_US".replace("_", "-")).toString());
    }
}
