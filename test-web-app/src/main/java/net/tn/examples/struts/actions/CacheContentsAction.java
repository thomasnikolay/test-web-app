/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.struts.actions;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.tn.examples.cache.inifinispan.CacheManager;

import org.infinispan.Cache;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jnicolay
 */
public class CacheContentsAction {

    private LinkedHashMap<String, Long> sizes;
    private List<Map<String, String>> cacheStatuse;
    private Map<String, String> cacheManagerStatus;
    private Map<String, String> cacheSyncTestEntries;
    private Map<String, String> systemProperties = new HashMap<>();

    public String execute() {

        org.slf4j.Logger Logger = LoggerFactory.getLogger(this.getClass());
        Logger.info("[CacheTestActions] this is the Action class loader {} ", this.getClass().getClassLoader().toString());

        Cache<String, Pojo> c5 = net.tn.examples.cache.inifinispan.CacheManager.Caches.TESTING.getCache();
        Logger.info("class loader 1 = {}", c5.getAdvancedCache().getClassLoader().toString());
        try {
            c5.put("test5", new Pojo("Meister", "Lampe"));
            Logger.info("Meister Lampe hat gesprochen!");
        } catch (Exception ex) {
            Logger.info("error1", ex);
        }

        c5 = c5.getAdvancedCache().with(this.getClass().getClassLoader());

        Logger.info("class loader 2 = {}", c5.getAdvancedCache().getClassLoader().toString());

        try {
            c5.put("test6", new Pojo("Schneee", "junge"));
            Logger.info("kskdf");
        } catch (Exception ex) {
            Logger.info("error2", ex);
        }

        c5 = net.tn.examples.cache.inifinispan.CacheManager.getInstance().createCache("bullshit_joe", 1000, 1000, 1000);
        Logger.info("class loader 3 = {}", c5.getAdvancedCache().getClassLoader().toString());
        try {
            c5.put("test6", new Pojo("bullshit", "junge"));
            Logger.info("kskdf");
        } catch (Exception ex) {
            Logger.info("error2", ex);
        }

        return "success";
    }

    public String collectCacheInformation() {
        CacheManager cm = CacheManager.getInstance();
        cacheManagerStatus = cm.getCacheMangerStatus();
        cacheStatuse = cm.getCacheStatus();
        cacheSyncTestEntries = CacheManager.Caches.TESTING.getCache();
        org.slf4j.Logger Logger = LoggerFactory.getLogger(this.getClass());
        if (!System.getProperties().isEmpty()) {
            Logger.info("[CacheContentsAction] collect system properties");
            for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
                Logger.trace("[CacheContentsAction] {} : {}", entry.getKey().toString(), entry.getValue().toString());
                if (entry.getKey() instanceof String && entry.getValue() instanceof String) {
                    systemProperties.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } else {
            Logger.info("[CacheContentsAction] system properties are empty");
        }

        return "success";
    }

    public LinkedHashMap<String, Long> getSizes() {
        return sizes;
    }

    public List<Map<String, String>> getCacheStatuse() {
        return Collections.unmodifiableList(cacheStatuse);
    }

    public Map<String, String> getCacheManagerStatus() {
        return Collections.unmodifiableMap(cacheManagerStatus);
    }

    public Map<String, String> getCacheSyncTestEntries() {
        return Collections.unmodifiableMap(cacheSyncTestEntries);
    }

    public Map<String, String> getSystemProperties() {
        return Collections.unmodifiableMap(systemProperties);
    }
}
