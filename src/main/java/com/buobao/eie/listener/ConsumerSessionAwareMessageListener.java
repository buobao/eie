package com.buobao.eie.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * Created by dqf on 2015/10/19.
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {

    private Destination destination;

    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        System.out.println("收到一条消息.");
        System.out.println("消息的内容是:"+textMessage.getText());
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
