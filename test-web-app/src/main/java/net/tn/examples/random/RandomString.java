/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.random;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author tnikolay
 */
public class RandomString {

    public static void main(String[] args) {
        System.out.println(RandomStringUtils.random(9));
        
    }
}
