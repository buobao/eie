package com.buobao.eie.listener;

import com.buobao.eie.entity.Email;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * Created by dqf on 2015/10/19.
 */
public class ConsumerListener {
    public void handleMessage(String message){
        System.out.println("ConsumerListener通过handleMessage接收到一个纯文本消息，消息的内容是:"+message);
    }

    public String receiveMessage(String message){
        System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是:"+message);
        return "这是ConsumerListener对象的receiveMessage方法的返回值.";
    }

    public void receiveMessage(Email email){
        System.out.println("接受到一个包含Email的ObjectMessage");
        System.out.println(email);
    }

    public void receiveMessage(ObjectMessage message) throws JMSException {
        System.out.println(message.getObject());
    }
}
