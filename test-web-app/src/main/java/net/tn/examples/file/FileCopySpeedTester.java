package net.tn.examples.file;

import java.io.File;
import java.nio.file.Files;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;

public class FileCopySpeedTester {

    public static void main(String[] args) throws InterruptedException, IOException {

        String inFile = "D:\\TEMP\\dump_mwb_1";
        String outFile = "D:\\TEMP\\dump_mwb_1_copy_";

        File source;
        File dest;

        long start = 0;

        // copy files using java.nio FileChannel
        source = new File(inFile);
        dest = new File(outFile + "2");
        start = System.currentTimeMillis();
        copyFileUsingChannel(source, dest);
        System.out.println("Time taken by Channel Copy = " + (System.currentTimeMillis() - start));

        // copy file conventional way using Stream
        source = new File(inFile);
        dest = new File(outFile+"1");
        start = System.currentTimeMillis();
        copyFileUsingStream(source, dest);
        System.out.println("Time taken by Stream Copy = " + (System.currentTimeMillis() - start));

        // copy files using apache commons io
        source = new File(inFile);
        dest = new File(outFile + "3");
        start = System.currentTimeMillis();
        copyFileUsingApacheCommonsIO(source, dest);
        System.out.println("Time taken by Apache Commons IO Copy = " + (System.currentTimeMillis() - start));

        // using Java 7 Files class
        source = new File(inFile);
        dest = new File(outFile + "4");
        start = System.currentTimeMillis();
        copyFileUsingJava7Files(source, dest);
        System.out.println("Time taken by Java7 Files Copy = " + (System.currentTimeMillis() - start));
    }

    private static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
        FileUtils.copyFile(source, dest);
    }

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[32768];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

}
