/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.locale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

/**
 *
 * @author tnikolay
 */
public class ResourceBundleConfigTest {
    public static void main(String[] args) {
        ResourceBundle.Control rbc =
              ResourceBundle.Control.getControl(Control.FORMAT_PROPERTIES);
        System.out.println(rbc.getCandidateLocales("test-lang", Locale.FRENCH));
    }
}
