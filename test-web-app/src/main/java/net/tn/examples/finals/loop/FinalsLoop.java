package net.tn.examples.finals.loop;

import java.util.Arrays;
import java.util.List;


public class FinalsLoop {

  /**
   * @lastChanged: tnikolay
   * @since 03.07.2014
   * @param args
   */
  public static void main(String[] args) {

    List<String> list = Arrays.asList("Kirk", "Janeway", "Picard", "Sisko", "Archer");
    
    for(String string : list) {
      System.out.println(string);
      string = "";
    }
    
  }

}
