/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.timer.thread;

import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author tnikolay
 */
public class InteruptedTimer {
    
    static class ATimerTask extends TimerTask{

        @Override
        public void run() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                return;
            }
            System.out.println("Thread ist noch gelaufen");
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        ATimerTask aTimerTask = new ATimerTask();
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(aTimerTask, 0, 1000, TimeUnit.MILLISECONDS);  
        Thread.sleep(100);
        aTimerTask.cancel();
        future.cancel(true);
    }
    
}
