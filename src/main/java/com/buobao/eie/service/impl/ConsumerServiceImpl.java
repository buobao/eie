package com.buobao.eie.service.impl;

import com.buobao.eie.service.ConsumerService;

import javax.jms.JMSException;

/**
 * Created by dqf on 2015/10/19.
 */
public class ConsumerServiceImpl implements ConsumerService {
    public void receiveMessage(String message) throws JMSException {
        System.out.println("----消费之接收消息----");
        System.out.println("----生产者发来的消息是:"+message);
    }
}
