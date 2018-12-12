/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.tools;

import org.apache.commons.lang.StringEscapeUtils;

/**
 *
 * @author tnikolay
 */
public class EscapeXml {
    public static void main(String[] args) {
        System.out.println(StringEscapeUtils.escapeXml("'"));
    }
}
