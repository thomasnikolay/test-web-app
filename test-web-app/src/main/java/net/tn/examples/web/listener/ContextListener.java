/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.tn.examples.jms.Communicator;

/**
 * Web application lifecycle listener.
 *
 * @author tnikolay
 */
public class ContextListener implements ServletContextListener {
    
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        CacheManager.init();
        Communicator.getInstance();
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        CacheManager.stop();
    }
}
