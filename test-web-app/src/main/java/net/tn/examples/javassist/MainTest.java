/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.javassist;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author tnikolay
 */
public class MainTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Map<String, Class<?>> props = new HashMap<String, Class<?>>();
	props.put("foo", Integer.class);
	props.put("bar", String.class);

	Class<?> clazz = PojoGenerator.generate(
			"net.javaforge.blog.javassist.Pojo$Generated", props, null);

	Object obj = clazz.newInstance();

	System.out.println("Clazz: " + clazz);
	System.out.println("Object: " + obj);
	System.out.println("Serializable? " + (obj instanceof Serializable));

	for (final Method method : clazz.getDeclaredMethods()) {
		System.out.println(method);
	}

	// set property "bar"
	clazz.getMethod("setBar", String.class).invoke(obj, "Hello World!");

	// get property "bar"
	String result = (String) clazz.getMethod("getBar").invoke(obj);
	System.out.println("Value for bar: " + result);

    }
}
