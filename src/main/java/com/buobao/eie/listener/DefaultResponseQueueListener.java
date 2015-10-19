package com.buobao.eie.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by dqf on 2015/10/19.
 */
public class DefaultResponseQueueListener implements MessageListener {
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;
            try {
                System.out.println("DefaultResponseQueueListener receive a text message which is send to defaultResponseQueue,context is:"+textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
