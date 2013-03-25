/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.issues.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author tnikolay
 */
public class Sup16759Smart2 extends ActionSupport implements Runnable {

    static Logger log = Logger.getLogger();

    @Override
    public String execute() throws Exception {
        System.out.println("Start execute");
        for (int i = 0; i < 1; i++) {
            new Thread(new Sup16759Smart2()).start();
        }

        System.out.println("end execute");
        return SUCCESS;
    }

    public void run() {

        for (int i = 0; i < 1; i++) {
            try {
                System.out.println(Thread.currentThread() + " Round " + i);
                ZipFile zipFile = new ZipFile("C:\\temp\\Smart\\ftp\\xpages\\il.zip");
                String basePath = "C:\\temp\\Smart\\ftp\\xpages\\il_test2";

                File outputFolder = new File(basePath);

                if (!outputFolder.exists()) {
                    outputFolder.mkdirs();
                    System.out.println("folder created " + i);
                }

                Enumeration<ZipEntry> xmlFiles = (Enumeration<ZipEntry>) zipFile.entries();

                while (xmlFiles.hasMoreElements()) {
                    ZipEntry entry = xmlFiles.nextElement();

                    InputStream is = zipFile.getInputStream(entry);
                    StreamSource ss = new StreamSource(is);

                    TransformerFactory factory = new TransformerFactoryImpl();

                    Transformer t = factory.newTransformer(new StreamSource(getClass().getResourceAsStream("sample.xsl")));
                    OutputStream os = new FileOutputStream(basePath + "\\" + entry.getName());
                    t.transform(ss, new StreamResult(os));

//                    is.close();
//                    os.close();
                }
//                zipFile.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
