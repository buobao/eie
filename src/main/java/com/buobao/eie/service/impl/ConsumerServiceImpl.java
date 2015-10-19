package com.buobao.eie.service.impl;

import com.buobao.eie.service.ConsumerService;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

/**
 * Created by dqf on 2015/10/19.
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    public void receiveMessage(String message) throws JMSException {
        System.out.println("----receiver get message----");
        System.out.println("----producer message:"+message);
    }
}
