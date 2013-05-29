/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.configuration;

import java.io.InputStream;
import java.util.List;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public final class Configuration {
    
    public enum KEYS {
	
	PLUGINS("plugins.plugin");        
	
	private String key;
	
	private KEYS(String key) {
	    this.key = key;
	}		
	
	public String getString() {
	    return getDefault().getXmlConfig().getString(key);
	}	
        
        public List<String> getList(){
            return getDefault().getXmlConfig().getList(key);
        }
	
    }

    private static Configuration instance = new Configuration();
    
    public static Configuration getDefault() {
	return instance;
    }
    
    private XMLConfiguration xmlConfig;

    public XMLConfiguration getXmlConfig() {
        return xmlConfig;
    }
       
    private Configuration() {
	xmlConfig = new XMLConfiguration();      
        final String confFileName = "/application.xml";
        InputStream is = this.getClass().getResourceAsStream(confFileName);
        try {
            xmlConfig.load(is);
        } catch (ConfigurationException ex) {
            System.out.println("[Configuration] can not load configuration from "+confFileName+" resaon: ");
            ex.printStackTrace();
        }
    }       
    public static void main(String[] args) {
        for (String string : Configuration.KEYS.PLUGINS.getList()) {
            System.out.println(string);
        }
        
    }
}
