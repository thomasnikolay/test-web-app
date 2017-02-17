/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tnikolay
 */
public class UploadTest {

    public UploadTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void uploadTest() throws FileNotFoundException, IOException {
        HttpClient client = HttpClientBuilder.create().build();   
        HttpPost post = new HttpPost("http://localhost:8980/swee-ucon-war/sappi/file-dispatcher");
        InputStream inputStream = new FileInputStream("C:\\Users\\tnikolay\\Desktop\\httpclient-4.5.1.jar");
        File file = new File("C:\\Users\\tnikolay\\Desktop\\duck_dussel01.gif");
        String message = "This is a multipart post";
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addBinaryBody("upfile", file, ContentType.DEFAULT_BINARY, "image.png");
        builder.addBinaryBody("upstream", inputStream, ContentType.create("application/zip"), "zip");
        builder.addTextBody("text", message, ContentType.TEXT_PLAIN);

        client.execute((HttpUriRequest) post);

    }
}
