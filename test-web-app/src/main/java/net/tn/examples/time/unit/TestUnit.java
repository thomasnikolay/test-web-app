package net.tn.examples.time.unit;

import java.util.concurrent.TimeUnit;


public class TestUnit {
    public static void main(String[] args) {
        TimeUnit tu = TimeUnit.DAYS;
        System.out.println(tu.toSeconds(365));
        
        TimeUnit tuM = TimeUnit.MINUTES;
        System.out.println(tuM.toMillis(1));
    }
}
