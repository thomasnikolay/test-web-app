/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.issues.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.FileHandler;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author tnikolay
 */
public class Sup16759Smart extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private StringBuilder outputString = new StringBuilder();
    private static int counter = 0;
    private boolean startTranscode = false;
    private static final Logger log = net.tn.issues.actions.Logger.getLogger();

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public String execute() throws Exception {
 
        log.info("\n------------------------------------------------------");
        log.info("\nincoming request at " + new Date());
        log.info("\nincoming request at " + new Date());
        log.info("\turl: " + request.getRequestURL());
        log.info("\tmethod: " + request.getMethod());
        log.info("\theader: " + request.getMethod());

        Enumeration headernames = request.getHeaderNames();

        while (headernames.hasMoreElements()) {
            String headerName = (String) headernames.nextElement();
            log.info("\t\t " + headerName + " = " + request.getHeader(headerName));
        }

        log.info("\tbody: ");
        log.info("\t\t" + IOUtils.toString(request.getInputStream()));
        log.info("\n" + IOUtils.toString(request.getInputStream()));

        if (counter < 50 || startTranscode) {
            counter++;
            log.info("Start File upload/transcoding round "+counter);
            FTPUploaderTest ftu = new FTPUploaderTest();
            Thread t = new Thread(ftu);
            t.start();
            log.info("End File upload/transcoding round"+counter);
        }

        return SUCCESS;
    }

    public StringBuilder getOutputString() {
        return new StringBuilder(outputString.toString().replaceAll("\n", "<br/>").replaceAll("\r", "<br/>"));
    }

    public void setStartTranscode(boolean startTranscode) {
        this.startTranscode = startTranscode;
    }
        
}
