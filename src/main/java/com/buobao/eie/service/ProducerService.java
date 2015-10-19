package com.buobao.eie.service;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * Created by dqf on 2015/10/19.
 */
public interface ProducerService {

    /**
     * 发送普通的纯文本消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, String message);

    /**
     * 发送一个ObjectMessage
     * @param destination
     * @param obj
     */
    public void sendMessage(Destination destination, Serializable obj);

}
