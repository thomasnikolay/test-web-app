/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author tnikolay
 */
public class Main {
    
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Private p = new Private();
        Field declaredField = Private.class.getDeclaredField("name");
        declaredField.setAccessible(true);
        Object get = declaredField.get(p);
        System.out.println(get);
    }
    
}
