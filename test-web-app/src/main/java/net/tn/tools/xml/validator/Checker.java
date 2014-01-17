/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.tools.xml.validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author tnikolay
 */
public class Checker {

    private void checkAllFilesFolder() throws FileNotFoundException {
        File file = new File("C:\\Users\\tnikolay\\Desktop\\de");
        if(file.isDirectory()){
            for (File file1 : file.listFiles()) {
                System.out.println("check "+file1.getAbsolutePath());
                checkXml(new FileInputStream(file1));
            }
        }else if(file.isFile()){
            System.out.println("check "+file.getAbsolutePath());
            checkXml(new FileInputStream(file));
        }
    }

    private void checkXml(InputStream is) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            builder.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    System.err.println(exception.getMessage());
                    exception.printStackTrace();
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    System.err.println(exception.getMessage());
                    exception.printStackTrace();
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    System.err.println(exception.getMessage());
                    exception.printStackTrace();
                }
            });

            Document document = builder.parse(new InputSource(is));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Checker checker = new Checker();
        checker.checkAllFilesFolder();
    }
}
