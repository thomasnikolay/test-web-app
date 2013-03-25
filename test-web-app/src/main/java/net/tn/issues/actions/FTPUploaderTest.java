package net.tn.issues.actions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tnikolay
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.net.ftp.FTP;

public class FTPUploaderTest implements Runnable {
    //prod

    private static final Logger LOG = Logger.getLogger();
    final static String host = "";
    final static String user = "";
    final static String pw = "";
    final static String directory = "daimlerftp/xpages";
    final static String baseTranscodingURL = "";
    //stage
//    final static String host = "";
//    final static String user = "";
//    final static String pw = "";
//    final static String directory = "/xpages";
//    final static String baseTranscodingURL = "";
    //local    
    boolean onlyLocal = false;
//    final static String baseTranscodingURL = "";
    final static String filename = "il.zip";
    final static String inputfile = "c:\\temp\\Smart\\ftp\\xpages\\il.zip";
    final static String notificationUrl = "http://twa.tn.apps.netbiscuits.com/struts-actions/sup-16759.action";
    static String transcodingUrl;

    public void uploadSmart() {
        try {
            transcodingUrl = baseTranscodingURL + "?password=MF4Aj9HmcK&mandant=il&in=" + filename + "&notificationUrl=" + URLEncoder.encode(notificationUrl, "UTF-8");
            if (!onlyLocal) {


                LOG.info(Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                LOG.info("load file to " + inputfile);
                LOG.info("CRC = " + calculateCrc32(inputfile));



                FTPClient ftp = new FTPClient();
                ftp.addProtocolCommandListener(new ProtocolCommandListener() {
                    public void protocolCommandSent(ProtocolCommandEvent pce) {
                        String command = pce.getCommand();
                        String message = pce.getMessage();
                        String replyCode = String.valueOf(pce.getReplyCode());
                        LOG.info(("FTP command executed-> " + command + " message: " + message + " replycode: " + replyCode).replaceAll("\n", "").replaceAll("\r", ""));
                    }

                    public void protocolReplyReceived(ProtocolCommandEvent pce) {
                        String command = pce.getCommand();
                        String message = pce.getMessage();
                        String replyCode = String.valueOf(pce.getReplyCode());

                        LOG.info(("FTP command executed-> " + command + " message: " + message + " replycode: " + replyCode).replaceAll("\n", "").replaceAll("\r", ""));
                    }
                });

                FTPClientConfig config = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
                ftp.configure(config);


                ftp.connect(host);
                int reply = ftp.getReplyCode();
                if (FTPReply.isPositiveCompletion(reply)) {
                    if (ftp.login(user, pw)) {
                        LOG.info(">> Logged in to " + host);

                        boolean cdSuccessful = ftp.changeWorkingDirectory(directory);

                        if (cdSuccessful) {

                            LOG.info(">> changing directory to " + directory + " has been performed");
                            InputStream is = new FileInputStream(new File(inputfile));
                            ftp.setFileType(FTP.BINARY_FILE_TYPE);
                            ftp.storeFile(filename, is);

                            URL url = new URL(transcodingUrl);

                            url.openConnection();

                            String result = IOUtils.toString(url.openStream());
                            if (result != null && !result.toLowerCase().contains("error")) {
                                LOG.info(result);
                            } else {
                                LOG.severe(result);
                            }

                            is.close();

                        } else {
                            LOG.info(">> changing directory to " + directory + " hasn't been performed");
                        }
                    }
                }
            } else {
                LOG.info("start tracoding to" + transcodingUrl);

                URL url = new URL(transcodingUrl);
                url.openConnection();
                String result = IOUtils.toString(url.openStream());
                if (result != null && !result.toLowerCase().contains("error")) {
                    LOG.info(result);
                } else {
                    LOG.severe(result);
                }
            }
        } catch (IOException e) {
            LOG.info("io exception" + e.getMessage());
        }
    }

    private long calculateCrc32(String inputFile) {
        try {
            File file = new File(inputFile);
            InputStream in = new FileInputStream(file);
            CRC32 crc = new CRC32();
            InputStream cis = new CheckedInputStream(in, crc);
            while (cis.read() != -1) { /* Bis zum Ende */ }
            return crc.getValue();
        } catch (IOException e) {
            LOG.info("calculateCrc32 error " + e);
            return 0;
        }


    }

    public void run() {
        try {
            uploadSmart();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FTPUploaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 1; i++) {
            new FTPUploaderTest().uploadSmart();
        }

    }
}