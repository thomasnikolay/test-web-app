/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.tools;

import java.text.Collator;
import java.util.Locale;


/**
 *
 * @author tnikolay
 */
public class CollatorExample {

    public static void main(String[] args) {
        Collator col = Collator.getInstance(Locale.ENGLISH);
        System.out.println(col.compare("Quaken", "Quäken"));

        
    }

}
