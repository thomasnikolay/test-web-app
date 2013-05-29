/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.jms;

/**
 * Interface to listen for incoming messages.
 *
 * All Messages will be sent to all Listeners.
 *
 * @author jnicolay
 */
public interface MessageListener {

    /**
     * Recieve the message. This method should not take too long to process. If
     * a message triggers a potentially length operation start a background task
     * to process it.
     *
     * @param msg
     */
    public void onMessage(Message msg);
}
