/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.struts.actions;

import java.io.Serializable;

/**
 *
 * @author tnikolay
 */
public class Pojo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String vorName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public Pojo(String name, String vorName) {
        this.name = name;
        this.vorName = vorName;
    }

    @Override
    public String toString() {
        return "Pojo{" + "name=" + name + ", vorName=" + vorName + '}';
    }
    
    
}
