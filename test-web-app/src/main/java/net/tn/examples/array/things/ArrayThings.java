/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.array.things;

/**
 *
 * @author tnikolay
 */
public class ArrayThings {
    public static void main(String[] args) {
        String[] iAmLegend = new String[10];
        
        for (int i = 0; i < iAmLegend.length; i++) {
            if(iAmLegend[i] == null){
                System.out.println("I am not the legend!");
            }
            
        }
    }
}
