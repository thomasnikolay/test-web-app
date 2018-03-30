/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.camel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Thomas
 */
public class TcpClient {
    
    public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 9292);
     
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
      out.write("hallo otto");
      out.flush();
      
      
      
        InputStream inputStream = s.getInputStream();
        
      byte[] buffer = new byte[8196];
      
      StringBuilder stringBuilder = new StringBuilder();
      
      while(inputStream.read(buffer) != -1 ){
          
          stringBuilder.append(buffer);                  
      }
      
      System.out.println(stringBuilder.toString());

      s.close();
    }
    catch(IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
    
}
