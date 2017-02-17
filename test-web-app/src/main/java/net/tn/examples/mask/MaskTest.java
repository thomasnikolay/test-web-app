/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.mask;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author tnikolay
 */
public class MaskTest {

    public static void main(String[] args) throws ParseException {
        MaskFormatter mf = new MaskFormatter("**-**-****");
        mf.setValueContainsLiteralCharacters(false);
        String valueToString = mf.valueToString("12031973");
        System.out.println(valueToString);       // 12-03-1973
        Object stringToValue = mf.stringToValue(valueToString);
        System.out.println(stringToValue);       // 12031973
    }
}
