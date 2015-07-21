/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.tools.cron.tester;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author tnikolay
 */
public class QuartzTest implements Job {

    public static void main(String[] args) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        try {
            Scheduler schedule = schedulerFactory.getScheduler();
                        
            schedule.start();
        } catch (SchedulerException ex) {
            Logger.getLogger(QuartzTest.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println(new Date());
    }
}
