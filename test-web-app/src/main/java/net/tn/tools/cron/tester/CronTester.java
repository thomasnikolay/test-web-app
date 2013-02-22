package net.tn.tools.cron.tester;


import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;

public class CronTester {

    public static void main(String[] args) throws ParseException {
        final String expression = "0 0 4 * * ?";
        final CronExpression cronExpression = new CronExpression(expression);

        Date nextValidDate1 = new Date();
        
        for (int i = 0; i < 10; i++) {
            nextValidDate1 = cronExpression.getNextValidTimeAfter(nextValidDate1);
            System.out.println(nextValidDate1);
            
        }
    }
}