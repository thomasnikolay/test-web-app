/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.tn.examples.cache.inifinispan.CacheManager;

import org.slf4j.LoggerFactory;

/**
 * Access point to send messages
 *
 * Free to use in plugins: - addMessageListener - getInstance - sendMessage
 *
 * @author jnicolay
 */
public class Communicator {
private static org.slf4j.Logger Logger = LoggerFactory.getLogger(CacheManager.class.getClass());
    private static final Communicator instance = new Communicator();
    private TopicConnection conn = null;
    private TopicSession session = null;
    private Topic topic = null;
    

    public static Communicator getInstance() {
        return instance;
    }
    private MessageListener[] listeners;

    private Communicator() {
        Logger.debug("[Communicator] initializing communicator");

        try {
            InitialContext iniCtx = new InitialContext();
            final String connectionFactoryJndiName = "ConnectionFactory";
            Object tmp = iniCtx.lookup(connectionFactoryJndiName);

            TopicConnectionFactory tcf = (TopicConnectionFactory) tmp;
            
            final String user = "fred";
            final String password = "password";
            
            conn = tcf.createTopicConnection(user, password);
            
            final String topicJndiName = "java:/topic/test";
            
            topic = (Topic) iniCtx.lookup(topicJndiName);

            session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);            
            conn.start();
            
            initSubsscriber();
        } catch (NamingException ex) {
            Logger.error("[Communicator] error by finding the JNDI name ", ex);
        } catch (JMSException ex) {
            Logger.error("[Communicator] error by connect to the JMS ystem", ex);
        }

        listeners = new MessageListener[0];
    }

    private void initSubsscriber() {
        try {
            TopicSubscriber recv = session.createSubscriber(topic);
            recv.setMessageListener(new javax.jms.MessageListener() {
                @Override
                public void onMessage(javax.jms.Message message) {
                    if (message instanceof ObjectMessage) {
                        ObjectMessage om = (ObjectMessage) message;
                        try {
                            Object messageObject = om.getObject();
                            if (messageObject instanceof Message) {
                                Message msge = (Message) messageObject;
                                MessageListener[] ls = listeners;
                                for (MessageListener l : ls) {
                                    l.onMessage(msge);
                                }
                            }
                        } catch (JMSException ex) {
                            Logger.error("an error is thrown by getting the message from object", ex);
                        }                        
                    } else {
                        Logger.error("[Communicator] it is not a object message");
                    }
                }
            });
        } catch (JMSException ex) {
            Logger.error("[Communicator] an error is thrown by receiving the message", ex);
        }
    }

    /**
     * Add a MessageListener to recieve Messages
     *
     * @param listener
     */
    public synchronized void addMessageListener(MessageListener listener) {
        final int oldlength = listeners.length;
        MessageListener[] newlist = new MessageListener[oldlength + 1];
        System.arraycopy(listeners, 0, newlist, 0, oldlength);
        newlist[oldlength] = listener;
        listeners = newlist;
    }

    public void stop() {
        Logger.info("[Communicator] stop communicator");
        try {
            conn.stop();
            session.close();
            conn.close();
        } catch (JMSException ex) {
            Logger.error("[Communicator] error by stopping the communicator", ex);
        }

    }

    /**
     * Send a Message
     *
     * @param msg
     */
    public void sendMessage(Message message) {
        Logger.debug("[Communicator] Begin sendAsync");
        try {
            
            ObjectMessage om = session.createObjectMessage(message);            
            TopicPublisher send = session.createPublisher(topic);
            send.publish(om);            
            Logger.debug("[Communicator] sendAsync, sent text=" + om.toString());
            send.close();
            Logger.debug("[Communicator] End sendAsync");

        } catch (JMSException ex) {

            Logger.error("[Communicator] error by sending the message", ex);
        }
    }



}
