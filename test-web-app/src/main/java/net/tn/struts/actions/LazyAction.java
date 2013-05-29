/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.io.InputStream;
import javax.servlet.ServletContext;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.util.ServletContextAware;

/**
 *
 * @author tnikolay
 */
@SuppressWarnings("serial")
public class LazyAction extends ActionSupport implements ServletContextAware {

    private String filePath;
    private ServletContext sc;
    private InputStream io;
    private String fileName;
    private int lazy;

    public LazyAction() {
    }

    @Override
    public String execute() throws Exception {
        if (lazy == 0) {
            lazy = 10000;
        }
        
        Thread.sleep(lazy);

        fileName = filePath;

        if (StringUtils.containsIgnoreCase(fileName, "/")) {
            fileName = fileName.substring(fileName.lastIndexOf("/"));
        }

        io = sc.getResourceAsStream(filePath);
        return SUCCESS;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setServletContext(ServletContext sc) {
        this.sc = sc;
    }

    public InputStream getIo() {
        return io;
    }

    public void setLazy(int lazy) {
        this.lazy = lazy;
    }
}