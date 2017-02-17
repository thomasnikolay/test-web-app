/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 *
 * @author tnikolay
 */
public class HelloWorldByter {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString("UTF-8".getBytes(Charset.forName("UTF-8"))));
    }
    
}
