package com.buobao.eie.listener;

import com.buobao.eie.entity.Email;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * Created by dqf on 2015/10/19.
 */
public class ConsumerListener {
    public void handleMessage(String message){
        System.out.println("ConsumerListener use handleMessage get a text message，context is:"+message);
    }

    public String receiveMessage(String message){
        System.out.println("ConsumerListener use receiveMessage get a text message，context is:"+message);
        return "This is ConsumerListener's receiveMessage method returning string.";
    }

    public void receiveMessage(Email email){
        System.out.println("receive a Email Message");
        System.out.println(email);
    }

    public void receiveMessage(ObjectMessage message) throws JMSException {
        System.out.println(message.getObject());
    }
}
