package net.tn.test.perfomance;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;


public class TestN3Loop {

  public static void main(String[] args) {

    int n = 2000;
    
    //Dies ist ein N³ Algorithmus für n < = 1000 ist es noch ok

    System.out.printf("initialize data n = %d \n", n);
    List<String> list = new ArrayList<String>(n);

    for(int i = 0; i <= n; i++) {
      list.add(UUID.randomUUID().toString());
    }

    System.out.printf("data initialized\n");

    long start = System.currentTimeMillis();
    int counter = 0;
    for(String string : list) {
      ListIterator<String> it = list.listIterator(list.size() - 1);
      for(String entry = it.previous(); it.hasPrevious(); entry = it.previous()) {        
        for(String string2 : list){
          
        }
      }

      if(counter > 0 && counter % (n/10) == 0) {
        double percent = (double)counter / (double)n;

//        System.out.println(percent + " " + counter + " " + n);

        System.out.printf("%.0f%%\n", percent * 100);
      }

      counter++;
    }

    long duration = System.currentTimeMillis() - start;

    System.out.printf("it tooks %d millis", duration);

  }
}
