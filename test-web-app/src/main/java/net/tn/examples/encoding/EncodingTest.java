package net.tn.examples.encoding;

import java.nio.charset.Charset;


public class EncodingTest {
    public static void main(String[] args) {
        String test ="�?��? 고르기";
        System.out.println(new String(test.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8")));
    }
}
