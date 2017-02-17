/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.soundex;

import org.apache.commons.codec.language.Soundex;

/**
 *
 * @author tnikolay
 */
public class SoundexTest {
    public static void main(String[] args) {
        Soundex e = new Soundex();
        System.out.println(e.soundex("Thomas"));
    }
    
}
