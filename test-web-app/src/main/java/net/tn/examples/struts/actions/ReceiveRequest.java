/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.struts.actions;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author tnikolay
 */
public class ReceiveRequest extends ActionSupport implements ServletRequestAware {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
    private StringBuilder outputString = new StringBuilder();

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public ReceiveRequest() {
    }

    public String execute() throws Exception {
        
        Logger log = new Logger();
        
        log.info("incoming request at "+new Date());
        log.info("\n\n\turl: "+request.getRequestURL());
        log.info("\n\n\tmethod: "+request.getMethod());
        log.info("\n\n\theader: "+request.getMethod());
        log.info("\n\n\tfrom: "+request.getRemoteAddr());
        log.info("\n\n\tfrom host: "+request.getRemoteAddr());        
        
        @SuppressWarnings("rawtypes")
		Enumeration headernames = request.getHeaderNames();
        
        while(headernames.hasMoreElements())
        {
            String headerName = (String) headernames.nextElement();
            log.info("\n\t\t "+ headerName + " = "+request.getHeader(headerName));
        }
        
        log.info("\n\n\tbody: ");
        log.info("\t\t"+IOUtils.toString(request.getInputStream()));        
        
        return SUCCESS;
    }
    
    private class Logger{

        public Logger() {
        }
        public void info(String msg){
            LoggerFactory.getLogger(ReceiveRequest.class).info(msg);
            System.out.println(msg);
            outputString.append(msg);
        }
    }

    public StringBuilder getOutputString() {   
        return new StringBuilder(outputString.toString().replaceAll("\n", "<br/>").replaceAll("\r", "<br/>"));
    }


    
}
