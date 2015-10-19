package com.buobao.eie.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;
import java.io.UnsupportedEncodingException;

/**
 * Created by dqf on 2015/10/19.
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {

    private Destination destination;

    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        System.out.println("Receive a message.");
        try {
            System.out.println("Context is:"+new String(textMessage.getText().getBytes(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        MessageProducer producer = session.createProducer(destination);
        Message thisMessage = session.createTextMessage("ConsumerSessionAwareMessageListener...");
        producer.send(thisMessage);
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
