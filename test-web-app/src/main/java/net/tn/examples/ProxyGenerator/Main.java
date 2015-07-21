/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import sun.misc.ProxyGenerator;

/**
 *
 * @author tnikolay
 */
public class Main {
    public static void main(String[] args) {
        ISomeService newProxyInstance = (ISomeService) Proxy.newProxyInstance(ISomeService.class.getClassLoader(), new Class[]{ISomeService.class}, new InvocationHandler() {
            
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  
                System.out.println(method.getName() + " called ");
                return null;
            }
        });
              
        newProxyInstance.getSomeString();
        newProxyInstance.goToHell();
                                
        
    }
    
}
