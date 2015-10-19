package com.buobao.eie.service;

import javax.jms.JMSException;

/**
 * Created by dqf on 2015/10/19.
 */
public interface ConsumerService {
    public void receiveMessage(String message) throws JMSException;
}
