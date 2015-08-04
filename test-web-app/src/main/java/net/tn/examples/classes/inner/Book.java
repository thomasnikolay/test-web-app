/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.classes.inner;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public class Book {

    String name = "";
    List<Page> pages = new ArrayList<Page>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }        
    
    //real inner class
    public class Page {

        Page(){
            Book.this.pages.add(this);
        }
        
        int number;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }                
    }    
}
