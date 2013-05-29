/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import net.tn.examples.jms.Communicator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Web application lifecycle listener.
 *
 * @author tnikolay
 */
public class ContextListener implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(ContextListener.class);
    
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
