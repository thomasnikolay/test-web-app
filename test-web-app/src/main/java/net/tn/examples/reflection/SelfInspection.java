/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author tnikolay
 */
public class SelfInspection {
    
    private Iterator<Long> test = new ArrayList<Long>().iterator();
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        SelfInspection si = new SelfInspection();        
        
        Field[] declaredFields = si.getClass().getDeclaredFields();
    
        for(Field field : declaredFields) {
      
      if(field.getType().getName().equalsIgnoreCase(Iterator.class.getName())){
          Iterator it = (Iterator) field.get(si);
          if(!it.hasNext()){              
              System.err.println("jo");
          }
      }
    }
    }
    
}
