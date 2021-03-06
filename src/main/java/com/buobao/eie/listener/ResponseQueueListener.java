package com.buobao.eie.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.UnsupportedEncodingException;

/**
 * Created by dqf on 2015/10/19.
 */
public class ResponseQueueListener implements MessageListener {
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;
            try {
                System.out.println("Receive a text message which is send to ResponseQueue,context is:"+new String(textMessage.getText().getBytes(),"UTF-8") );
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
