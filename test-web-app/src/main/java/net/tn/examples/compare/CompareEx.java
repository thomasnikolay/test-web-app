package net.tn.examples.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CompareEx implements Comparable<CompareEx>{

    @Override
    public int compareTo(CompareEx o) {
        
        if(o == this){
            return 0;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        
        List<CompareEx> list = new ArrayList<>(5);
        
        CompareEx ex = new CompareEx();
        CompareEx ex2 = new CompareEx();
        
        list.add(ex);
        list.add(ex);
        list.add(ex2);
        
        Collections.sort(list);
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
    
}
