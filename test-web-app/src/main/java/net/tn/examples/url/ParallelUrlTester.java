/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.url;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author tnikolay
 */
public class ParallelUrlTester {

    public static void main(String[] args) throws Throwable {

        final String[] urls = {"http://localhost:8580/swee-mwb/mobile-sync/3076/file/com.gk_software.cst.swee.tbm.ses.api.repl.data.adapter.mobile.group.delta.IDeltaCentralReturnReplicationGroup/delta_centralreturn.hcc"
                        , "http://localhost:8580/swee-mwb-war/mobile-sync/3076/syncList"};
        final String[] methods = {"GET", "POST"};
        
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\tnikolay\\Desktop\\body.txt");
        
        StringBuilder sb = new StringBuilder();
        int reading;
        while((reading = fileInputStream.read()) > -1){
            sb.append((char)reading);
        }
        
        System.out.println("body read: "+ sb.toString());
        
        final String[] bodies = {"",sb.toString()};
        
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(200);
            int position = 0;
            final String urlRaw = urls[position];
            final String method = methods[position];
            final String body = bodies[position];
            new Thread() {
                @Override
                public void run() {
                    try{
                    URL url = new URL(urlRaw);
                    HttpURLConnection conn
                            = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(method);
                    conn.setUseCaches(false);                              
                    
                    if(StringUtils.isNotEmpty(body)){
                            conn.setDoOutput(true);
                            OutputStream outputStream = conn.getOutputStream();
                            outputStream.write(body.getBytes());
                            outputStream.close();
                        }
                           
                    if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {                        
                        System.out.println(conn.getResponseMessage());                        
                    }
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                }

            }.start();
        }
    }
}
