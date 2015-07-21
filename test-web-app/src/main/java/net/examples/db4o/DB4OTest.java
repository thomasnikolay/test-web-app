/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.examples.db4o;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.internal.Config4Impl;
import java.util.UUID;

/**
 *
 * @author tnikolay
 */
public class DB4OTest {

    public static void main(String[] args) {
        
        Config4Impl config4Impl = new Config4Impl();     
        
        
        ObjectContainer db = Db4o.openFile("d:/test-data-file.db4o");
        ObjectContainer db2 = Db4o.openFile("d:/test-data-file.db4o");
                
        
        try {
            // Speichere zwei Personen
            for (int i = 0; i < 10; i++) {
                db.store(new Object() {
                    String msg = UUID.randomUUID().toString();

                    @Override
                    public String toString() {
                        return "{" + "msg=" + msg + '}';
                    }                                        
                });
                db2.store(new Object() {
                    String msg = UUID.randomUUID().toString();

                    @Override
                    public String toString() {
                        return "{" + "msg=" + msg + '}';
                    }                                        
                });
            }
            
            
            // Iteriere über alle Personen
            ObjectSet result = db.queryByExample(new Object());
            while (result.hasNext()) {
                System.out.println(result.next().toString());
            }
            // Schreibe die Änderungen fest
            db.commit();
        } finally {
            // Schließe die Datenbank
            db.close();
        }
    }

}
