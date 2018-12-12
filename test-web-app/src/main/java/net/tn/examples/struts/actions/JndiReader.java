/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.struts.actions;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author tnikolay
 */
@SuppressWarnings("serial")
public class JndiReader extends ActionSupport {

    public JndiReader() {
    }

    @Override
    public String execute() throws Exception {
        System.out.println("\nJNDI-Context-Listing:\n");       

        System.out.println("only this top level entries avavailable");


        return SUCCESS;
    }

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        System.out.println("\nJNDI-Context-Listing:\n");

        ctx.close();
    }

    public static void showJndiContext(Context ctx, String name, String space) {
        if (null == name) {
            name = "";
        }
        if (null == space) {
            space = "";
        }
        try {
            NamingEnumeration<NameClassPair> en = ctx.list(name);
            while (en != null && en.hasMoreElements()) {
                String delim = (name.length() > 0) ? "/" : "";
                NameClassPair ncp = en.next();
                System.out.println(space + name + delim + ncp);
                showJndiContext(ctx, ncp.getName(), "    " + space);
            }
        } catch (javax.naming.NamingException ex) {
            ex.printStackTrace();
        }
    }
}