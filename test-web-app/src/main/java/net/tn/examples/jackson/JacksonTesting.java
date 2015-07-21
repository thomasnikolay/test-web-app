/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author tnikolay
 */
public class JacksonTesting {

    public static void main(String[] args) throws IOException {
        new JacksonTesting().test();
    }

    private void test() throws IOException {

        ObjectMapper om = new ObjectMapper();

        Object complicatedObject = new Object() {
            public HashMap<String, String> map = new HashMap<String, String>();
            public ArrayList<Object> objects = new ArrayList<Object>();

            {
                for (int i = 0; i < 10; i++) {
                    map.put("key" + i, "value" + i);
                }

                objects.add(new Integer(1));
                objects.add(new String("test"));
                objects.add(new Double(2.2));
                objects.add(new Object() {                    
                });
            }
        ;
        };
        
        System.out.println("This does not work. It don't know, how are serialize the object!");
        System.out.println(om.writeValueAsString(complicatedObject));

    }
}
