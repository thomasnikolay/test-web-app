package net.tn.examples.packages;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;


public class PackageTest {
    public static void main(String[] args) throws URISyntaxException{
        URL resource = ClassLoader.getSystemClassLoader().getResource("");
        File directory = new File(resource.toURI());
        System.out.println(directory.isDirectory());
        for (File file : directory.listFiles()) {
            System.out.println(file.getName());
        }
    }
}
