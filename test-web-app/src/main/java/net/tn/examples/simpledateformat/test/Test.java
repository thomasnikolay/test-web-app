package net.tn.examples.simpledateformat.test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {

  /**
   * @lastChanged: tnikolay
   * @since 02.09.2014
   * @param args
   */
  public static void main(String[] args) {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    
    System.out.println(simpleDateFormat.format(new Date()));
    
  }

}
