/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.struts.actions;

import java.util.Map;

import net.tn.examples.cache.inifinispan.CacheManager;

/**
 *
 * @author tnikolay
 */
public class CacheTestActions {

    private Map <String, String> tests = CacheManager.Caches.TESTING.getCache();
    
    public CacheTestActions() {
    }

    public String execute() throws Exception {
        

        return "success";
    }

    public Map<String, String> getTests() {
        return tests;
    }
    
    
}