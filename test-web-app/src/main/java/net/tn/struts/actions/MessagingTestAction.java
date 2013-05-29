/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.struts.actions;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.tn.examples.cache.inifinispan.CacheManager;
import net.tn.examples.jms.Communicator;
import net.tn.examples.jms.Message;
import net.tn.examples.jms.MessageListener;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tnikolay
 */
public class MessagingTestAction {
private static org.slf4j.Logger Logger = LoggerFactory.getLogger(CacheManager.class.getClass());
    private final static List<String> list = new ArrayList<>();
    private final static TestListener testListener = new TestListener();
    
    static{
        Communicator.getInstance().addMessageListener(testListener);        
    }

    public String execute() {
        String serverName = System.getProperty("jboss.server.name");
        Communicator.getInstance().sendMessage(new TestMessage("from: "+ serverName + " time: "+new Date(), true));
        return "success";
    }

    public List<String> getList() {
        return Collections.synchronizedList(Collections.unmodifiableList(new ArrayList<>(list)));
    }

    @SuppressWarnings("serial")
    static class TestMessage implements Message {
        private final String message;
        private final boolean sendNext;

        public TestMessage(String message, boolean sendNext) {
            this.sendNext = sendNext;
            this.message = message;
        }
        
        public String getMessage() {
            return message;
        }

        public boolean isSendNext() {
            return sendNext;
        }
               
        @Override
        public String toString() {
            return "TestMessage{" + "message=" + message + '}';
        }        
    }

    static class TestListener implements MessageListener {

        @Override
        public void onMessage(Message msg) {
            if (msg instanceof TestMessage) {
                TestMessage tm = (TestMessage) msg;
                list.add(tm.getMessage());
                if(tm.isSendNext()){
                    String serverName = System.getProperty("jboss.server.name");
                    Communicator.getInstance().sendMessage(new TestMessage("from: "+ serverName + " time: "+new Date(), false));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\test.object"));
        out.writeObject(new TestMessage("from: kirby time: "+new Date(), false));
    }
}
