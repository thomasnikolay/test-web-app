/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.collator;

import java.text.Collator;
import java.util.Locale;

/**
 *
 * @author tnikolay
 */
public class CollatorTest {
    public static void main(String[] args) {
        Collator c =Collator.getInstance(Locale.GERMAN);
        c.setStrength(Collator.TERTIARY);
        System.out.println(c.compare("manno", "männo"));
        System.out.println("20113080".compareTo("WS11KT2055048"));
        System.out.println("WS11KT2055048".compareTo("WU11KT2023034"));
    }
}
