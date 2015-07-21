/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.trash;

/**
 *
 * @author tnikolay
 */
public class Trash {
    
    public static void main(String[] args) {
        String showPath = "//shows/academy_of_country_music/";
        String tmp = showPath.endsWith("/") ? showPath.substring(0, showPath.length()-1) : showPath;
        System.out.println(tmp.substring(tmp.lastIndexOf("/")+1).replaceAll("-","_"));
    }
    
}
