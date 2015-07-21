/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.string;

import java.io.File;

/**
 *
 * @author tnikolay
 */
public class SplitTest {
    
    public static void main(String[] args) {
        
        File outfile = new File("C:\\Users\\tnikolay\\Desktop\\1423926009690_deltaworkpool.hcc-CRC-20150214160009690-1423926009686.data.tmp");
        
        long hccCRC = 0;
        
        System.out.println(outfile.getParent() + File.separator + outfile.getName().split("CRC")[0] + Long.toString(hccCRC)
          + outfile.getName().split("CRC")[1]);
        
    }
    
}
