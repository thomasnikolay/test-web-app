/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.examples.javassist;

import java.util.HashMap;
import java.util.Map;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author tnikolay
 */
public class MainTest2 {
    
    public static void main(String[] args) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
        Map<String, Class<?>> props = new HashMap<String, Class<?>>();
	props.put("foo", String.class);
	props.put("bar", String.class);
        
        Class clazz = PojoGenerator.generate("BullShit", props);
        Object newInstance = clazz.newInstance();
        
        System.out.println(ReflectionToStringBuilder.reflectionToString(newInstance));
        
        
    }
    
}
