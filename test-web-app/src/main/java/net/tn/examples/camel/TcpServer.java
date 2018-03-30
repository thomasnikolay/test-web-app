/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.camel;

import java.io.InputStream;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

/**
 *
 * @author Thomas
 */
public class TcpServer {
    
    public static void main(String[] args) {
        //    final String input_endpoint = "netty:tcp://localHost:9292?sync=true&allowDefaultCodec=false&textline=true";
//    final String input_endpoint = "netty:tcp://localHost:9292?sync=true&allowDefaultCodec=false&encoder=#stringEncoder&decoder=#stringDecoder";
    final String input_endpoint = "netty:tcp://localHost:9292?sync=true&allowDefaultCodec=false";
    
    CamelContext context = new DefaultCamelContext();
    
    try {
      context.addRoutes(new RouteBuilder() {
        
        public void configure() {
          from(input_endpoint).process(new Processor() {

  
            @Override
            public void process(Exchange exchange) throws Exception {
              System.out.println(exchange.getIn().getBody(String.class));
              exchange.getOut().setBody("hallo marvin", String.class);
              
             
              try {

              } catch(Exception e) {
                e.printStackTrace();
              }
            }
          });
        }
      });

      context.start();
    } catch(Exception e) {
      e.printStackTrace();
    }
    
  }
        
        
    
    
}
