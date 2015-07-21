package net.tn.examples.parse.number;

import java.math.BigInteger;


public class ParseInteger {

  public static void main(String[] args) {

    String a = "1", b = "10000000000000000000000000000000000";
    
    try{
      Integer.parseInt(a);
    }catch(NumberFormatException ex){
      ex.printStackTrace();
    }
    
    try{
      Integer.parseInt(b);      
    }catch(NumberFormatException ex){
      ex.printStackTrace();
    }
    
    
    System.out.println(new BigInteger(b).pow(50));
    
   

  }

}
