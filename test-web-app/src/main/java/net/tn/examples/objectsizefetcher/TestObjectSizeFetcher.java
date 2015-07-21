/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.objectsizefetcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author tnikolay
 */
public class TestObjectSizeFetcher {

    public static void main(String[] args) throws IOException {
        new TestObjectSizeFetcher().test();
    }

    private void test() throws IOException {

        Object complicatedObject = new Object() {
            HashMap<String, String> map = new HashMap<String, String>();
            ArrayList<Object> objects = new ArrayList<Object>();

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



        System.out.println(ObjectSizeFetcher.getObjectSize(complicatedObject));
    }
}
