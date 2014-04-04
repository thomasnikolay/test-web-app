package net.examples.url;

import java.net.URI;


public class UrlTest {
    public static void main(String[] args) throws Exception{
        URI url = new URI("www.mtv.com/content/ontv/vma/2012/xml/winners.jhtml");
        System.out.println(url);
        System.out.println(url.getScheme());
        System.out.println(url.getScheme().matches("https"));
    }
}
