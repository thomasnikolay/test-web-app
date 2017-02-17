/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples;

import java.util.List;

/**
 *
 * @author tnikolay
 */
public class PoJo {
    private String name;
    private String age;
    private List<String> listOfString;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getListOfString() {
        return listOfString;
    }

    public void setListOfString(List<String> listOfString) {
        this.listOfString = listOfString;
    }    
    
}
