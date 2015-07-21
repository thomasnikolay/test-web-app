/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.cache.inifinispan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


import org.infinispan.Cache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfiguration;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.stats.Stats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tnikolay
 */
public class CacheManager {
    
    private static Logger Logger = LoggerFactory.getLogger(CacheManager.class.getClass());
    //this property definied the replication mode
    private final static CacheMode REPLICATION_CACHE_MODE = CacheMode.REPL_SYNC;
    //this property is set to local cache, if no cache from JBoss available
    private static CacheMode fallbackCacheMode = null;
    private static DefaultCacheManager manager;
    private static final String UNIQUE_CACHE_IDENTIFIER = "_" + "TEST";
    private static final long HALF_DAY_IN_MILLIS = 43200000L;
    private static final long THREE_DAYS_IN_MILLIS = 259200000L;
    private static CacheManager instance = new CacheManager();
    private static double maxEntriesFactor = 1.0;
    
    public enum Caches {
        
        PRE_PARSED_FEEDS(REPLICATION_CACHE_MODE, 50000, THREE_DAYS_IN_MILLIS, THREE_DAYS_IN_MILLIS),
        PARSED_FEEDS(REPLICATION_CACHE_MODE, 25000, THREE_DAYS_IN_MILLIS, THREE_DAYS_IN_MILLIS),
        UPLOAD_JOBS(CacheMode.LOCAL, 10000, HALF_DAY_IN_MILLIS, HALF_DAY_IN_MILLIS),
        VIDEO_IDS(REPLICATION_CACHE_MODE, 10000, HALF_DAY_IN_MILLIS, HALF_DAY_IN_MILLIS),
        FEED_ALERTS(CacheMode.LOCAL, 10000, HALF_DAY_IN_MILLIS, HALF_DAY_IN_MILLIS),
        FM_FILES(CacheMode.LOCAL, 500, 10000, 10000),
        CONFIG_FILES(CacheMode.LOCAL, 500, 10000, 1000),
        RBML_FILES(REPLICATION_CACHE_MODE, 500, 10000, 1000),
        PAGE_SIZES(REPLICATION_CACHE_MODE, 500, HALF_DAY_IN_MILLIS, HALF_DAY_IN_MILLIS),
        FB_USERS(REPLICATION_CACHE_MODE, 2000, HALF_DAY_IN_MILLIS, HALF_DAY_IN_MILLIS),
        BITLY(REPLICATION_CACHE_MODE, 2000, THREE_DAYS_IN_MILLIS, THREE_DAYS_IN_MILLIS),
        FEED_TIMEOUT_CACHE(REPLICATION_CACHE_MODE, 10000, 30000, 30000),
        IP_GEO_INFORMATIONS(REPLICATION_CACHE_MODE, 40000, THREE_DAYS_IN_MILLIS, THREE_DAYS_IN_MILLIS),
        CUSTOMER_ACCOUNTS(CacheMode.LOCAL, 20, 120, 120),
        TESTING(REPLICATION_CACHE_MODE, 5000, -1, -1);
        private String cacheName;
        private CacheMode cacheMode;
        private int maxEntries;
        private long lifespan;
        private long maxIdle;
        
        private Caches(CacheMode cm, int maxEntries, long lifespan, long maxIdle) {
            this.cacheName = name() + UNIQUE_CACHE_IDENTIFIER;
            this.cacheMode = cm;
            this.maxEntries = maxEntries;
            this.lifespan = lifespan;
            this.maxIdle = maxIdle;
        }
        
        public <K, V> Cache<K, V> getCache() {
            return CacheManager.getInstance().getCache(this);
        }
        
        private String getCacheName() {
            return cacheName;
        }
        
        private CacheMode getCacheMode() {
            return cacheMode;
        }
        
        private long getLifespan() {
            return lifespan;
        }
        
        private int getMaxEntries() {
            return maxEntries;
        }
        
        private long getMaxIdle() {
            return maxIdle;
        }
    }
    
    private CacheManager() {
        if (manager == null) {
//            final double maxEntriesFactorTmp = 1.0;
//            this.maxEntriesFactor = maxEntriesFactorTmp != 0 ? maxEntriesFactorTmp : this.maxEntriesFactor;

//            currently is it not possible to use the standard infinispan from the JBoss Enviroment
//            because there exist a bug on the classloader assigment on embeded cache up to JBoss 7.1.3 should it work

            
            GlobalConfiguration glob = new GlobalConfigurationBuilder()
                    .clusteredDefault()
                    .transport()
                    .defaultTransport()
                    .addProperty("configurationFile", "jgroups-udp.xml")
                    .defaultTransport()
                    .clusterName("TEST-CACHE-CLUSTER")
                    .globalJmxStatistics().allowDuplicateDomains(true).enable()
                    .build();
            
            Configuration loc = new ConfigurationBuilder()
                    .clustering().stateTransfer().awaitInitialTransfer(true)
                    .clustering().stateTransfer().fetchInMemoryState(true)
                    .jmxStatistics().enable()
                    .build();
            
            manager = new DefaultCacheManager(glob, loc, true);
            
        }
    }
    
    private static void initializeCaches() {
        for (Caches caches : Caches.values()) {
            if (!manager.cacheExists(caches.getCacheName())) {
                manager.defineConfiguration(caches.getCacheName(), new ConfigurationBuilder()
                        .jmxStatistics().enable()
                        .clustering().cacheMode(fallbackCacheMode == null ? caches.getCacheMode() : fallbackCacheMode)
//                        .clustering().stateTransfer().chunkSize(0)
//                        .clustering().stateTransfer().timeout(20000)
//                        .clustering().sync().replTimeout(20000)
//                        .clustering().stateTransfer().awaitInitialTransfer(true)
//                        .clustering().stateTransfer().fetchInMemoryState(true)
                        .eviction().maxEntries(calculateFactor(caches.getMaxEntries()))
                        .expiration().lifespan(caches.getLifespan()).maxIdle(caches.getMaxIdle())
                        .build()).invocationBatching();
                manager.startCache(caches.getCacheName());
            } else {
                Logger.info("{} already definied", caches.getCacheName());
            }
        }
    }
    
    private static void addTestEntries() {
        try {
            String hostname = System.getProperty("jboss.host.name");
            String javaHome = System.getProperty("java.home");
            String javaVersion = System.getProperty("java.version");
            String serverName = System.getProperty("jboss.server.name");
            Cache<String, String> tc = manager.getCache(Caches.TESTING.getCacheName());
            
            String identifier = serverName + "@" + hostname + "@" + manager.getClusterName();
            Logger.info("[CacheManager] identifier = {}", identifier);
            Map<String, String> tmpMap = new HashMap<>();
            
            tmpMap.put("test", "test");
            String key1 = identifier + "@java-version";
            tmpMap.put(key1, javaVersion);
            String key2 = identifier + "@java-home";
            tmpMap.put(key2, javaHome);
            String key3 = identifier + "@start-date-sync";
            tmpMap.put(key3, String.valueOf(new Date().getTime()));            
            String key4 = identifier + "@cluster-member";
            tmpMap.put(key4, Arrays.toString(manager.getMembers().toArray()));
                       
            tc.putAll(tmpMap);
            
        } catch (Exception e) {
            Logger.error("[CacheManager] error by loading system properties for cache testing", e);
        }
    }
    
    public static void init() {
        initializeCaches();
        addTestEntries();
    }
    
    public static CacheManager getInstance() {
        return instance;
    }
    
    public static void stop() {
        stopCaches();
        stopCacheManager();
    }
    
    private static void stopCaches() {
        if (manager != null) {
            for (String cacheName : manager.getCacheNames()) {
                if (manager.cacheExists(cacheName) && manager.isRunning(cacheName)) {
                    manager.getCache(cacheName).stop();
                }
            }
        }
    }
    
    private static void stopCacheManager() {
        //only if the manager instantiated from the application and not from the jboss
        if (manager != null) {
            manager.stop();
        }
    }
    
    public List<Map<String, String>> getCacheStatus() {
        List<Map<String, String>> cacheStatus = new ArrayList<>();
        
        for (String name : manager.getCacheNames()) {
            Cache<?, ?> cache = manager.getCache(name);
            Stats cacheStats = cache.getAdvancedCache().getStats();
            
            Map<String, String> properties = new LinkedHashMap<>();
            cacheStatus.add(properties);
            properties.put("cache name", name);
            properties.put("is running", String.valueOf(manager.isRunning(name)));
            properties.put("MaxEntries", String.valueOf(cache.getCacheConfiguration().eviction().maxEntries()));
            properties.put("EvictionStrategy", cache.getCacheConfiguration().eviction().strategy().name());
            properties.put("ThreadPolicy", cache.getCacheConfiguration().eviction().threadPolicy().name());
            properties.put("CurrentNumberOfEntries", String.valueOf(cacheStats.getCurrentNumberOfEntries()));
            properties.put("Evictions", String.valueOf(cacheStats.getEvictions()));
            properties.put("Hits", String.valueOf(cacheStats.getHits()));
            properties.put("Misses", String.valueOf(cacheStats.getMisses()));
            properties.put("RemoveHits", String.valueOf(cacheStats.getRemoveHits()));
            properties.put("RemoveMisses", String.valueOf(cacheStats.getRemoveMisses()));
            properties.put("Retrievals", String.valueOf(cacheStats.getRetrievals()));
            properties.put("Stores", String.valueOf(cacheStats.getStores()));
            properties.put("TimeSinceStart", String.valueOf(cacheStats.getTimeSinceStart()));
            properties.put("TotalNumberOfEntries", String.valueOf(cacheStats.getTotalNumberOfEntries()));
            properties.put("ClassLoader", cache.getAdvancedCache().getClassLoader().toString());
            
        }
        
        Collections.sort(cacheStatus,
                new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> obj1,
                    Map<String, String> obj2) {
                return (obj1.get("cache name").compareTo(obj2.get("cache name")));
            }
        });
        
        return cacheStatus;
    }
    
    public Map<String, String> getCacheMangerStatus() {
        Map<String, String> properties = new LinkedHashMap<>();
        
        properties.put("cluster name", manager.getClusterName());
        properties.put("node address", manager.getAddress().toString());
        properties.put("cluster members", Arrays.toString(manager.getMembers().toArray()));
        properties.put("cluster size", String.valueOf(manager.getMembers().size()));
        properties.put("created cache count", String.valueOf(manager.getCacheNames().size()));
        
        int runningCacheCounter = 0;
        boolean first = true;
        
        for (String cacheName : manager.getCacheNames()) {
            if (manager.cacheExists(cacheName)) {
                runningCacheCounter++;
                if (first == true) {
                    first = false;
                    properties.put("infinspan version", manager.getCache(cacheName).getVersion());
                }
            }
        }
        
        properties.put("running cache count", String.valueOf(runningCacheCounter));
        
        return properties;
    }
    
    public <K, V> Cache<K, V> getCache(String name) {
        String cacheName = getCustomizedCacheName(name);
        if (!manager.cacheExists(cacheName)) {
            createCache(cacheName, 10000, 43200000, 7200000);
            Logger.info("[CacherManager] create cache " + cacheName + " with default values");
        }
        
        return manager.getCache(name);
    }
    
    public <K, V> Cache<K, V> createCache(String name, int maxEntries, long lifespan, long maxIdle) {
        String cacheName = getCustomizedCacheName(name);
        if (!manager.cacheExists(cacheName)) {
            manager.defineConfiguration(cacheName, new ConfigurationBuilder()
                    .jmxStatistics().enable()
                    .clustering().cacheMode(fallbackCacheMode == null ? REPLICATION_CACHE_MODE : fallbackCacheMode)
                    .eviction().maxEntries(maxEntries)
                    .expiration().lifespan(lifespan).maxIdle(maxIdle)
                    .build());
        }
        return manager.getCache();
    }
    
    private String getCustomizedCacheName(String cacheName) {
        if (cacheName != null && cacheName.endsWith(UNIQUE_CACHE_IDENTIFIER)) {
            return cacheName;
        } else {
            return cacheName + UNIQUE_CACHE_IDENTIFIER;
        }
    }
    
    private <K, V> Cache<K, V> getCache(Caches cache) {
        return getCache(cache.getCacheName());
    }
    
    private static int calculateFactor(int maxEntries) {
        return (int) (maxEntries * maxEntriesFactor);
    }
}
