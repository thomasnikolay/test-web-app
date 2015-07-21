/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.osbean;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 *
 * @author tnikolay
 */
public class OSBeanTest {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
OperatingSystemMXBean.class);
                System.out.println(osBean.getArch());
                System.out.println(osBean.getAvailableProcessors());
                System.out.println(osBean.getName());
                System.out.println(osBean.getSystemLoadAverage());
                System.out.println(osBean.getVersion());
        
    }
    
}
