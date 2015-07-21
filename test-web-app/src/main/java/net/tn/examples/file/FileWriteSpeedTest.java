package net.tn.examples.file;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.lang.StringEscapeUtils;


public class FileWriteSpeedTest {

  public static void main(String[] args) throws Exception {
    String fileName = "D:\\test-time-file.txt";
    
    int from = 32, to = 126, lines = 10000000;

    StringBuffer sb = new StringBuffer(to - from);
    for(int i = from; i <= to; i++) {
      sb.append((char)i);
    }
    sb.append("\n");
    
    String tmp = sb.toString();
    byte[] buffer = tmp.getBytes();
    int bufferLength = buffer.length;
    
    System.out.printf("Start to write the line '%s' %d times\n", StringEscapeUtils.escapeJava(tmp), lines);    
    
    
    //That is the fastet way to write a file in Java
    RandomAccessFile file = new RandomAccessFile(fileName, "rw");
    FileChannel rwChannel = file.getChannel();
    ByteBuffer wrBuf = rwChannel.map(FileChannel.MapMode.READ_WRITE, 0, buffer.length * lines);
    
    long start = System.currentTimeMillis();        

    for(int i = 0; i < lines; i++) {
      wrBuf.put(buffer, 0, bufferLength);            
    }
        
    rwChannel.close();
    file.close();
            
    long end = System.currentTimeMillis();

    long fileSize = getFileSize(fileName);

    System.out.printf("I need %s millis and I wrote %d bytes (%d MB)\n", end - start, fileSize ,fileSize / (1024 * 1024));

  }


  private static long getFileSize(String fileName) {

    File file = new File(fileName);
    return file.length();

  }

}
