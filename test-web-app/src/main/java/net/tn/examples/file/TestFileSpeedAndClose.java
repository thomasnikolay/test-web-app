/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author tnikolay
 */
public class TestFileSpeedAndClose {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File srcfile = new File("d:\\1423926009690_deltaworkpool.hcc-CRC-20150214160009690-1423926009686.data.tmp");        
        File desfile = new File("d:\\1423926009690_deltaworkpool.hcc-CRC-20150214160009690-1423926009686.data");    
        desfile.delete();
        OutputStream os = new FileOutputStream(srcfile);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 63; i < 150; i++){
            sb.append((char)i);            
        }
        byte[] tmp = sb.toString().getBytes();
        
        for(int i = 0; i < 9999999;i++){
            os.write(tmp);            
        }        
        os.close();
        srcfile.renameTo(desfile);
        if(desfile.exists()){
            System.out.println("super!!");
        }
    }
    
}
