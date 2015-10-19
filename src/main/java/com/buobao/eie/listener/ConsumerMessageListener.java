package com.buobao.eie.listener;

import com.buobao.eie.entity.Email;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.*;

/**
 * Created by dqf on 2015/10/19.
 */
public class ConsumerMessageListener implements MessageListener {
    private MessageConverter messageConverter;

    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            TextMessage textMsg = (TextMessage)message;
            System.out.println("接收到一个纯文本消息.");
             try{
                 System.out.println("消息的内容是:"+textMsg.getText());
             }catch (JMSException e){
                 e.printStackTrace();
             }
        } else if (message instanceof MapMessage){
            MapMessage mapMessage = (MapMessage)message;
        } else if (message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage)message;
            try{
                Email email = (Email)messageConverter.fromMessage(objectMessage);
                System.out.println("接收到一个ObjectMessage,包含Enail对象.");
                System.out.println("email");
            }catch (JMSException e){e.printStackTrace();}
        }

    }

    public  MessageConverter getMessageConverter(){
        return messageConverter;
    }

    public void setMessageConverter(MessageConverter messageConverter){
        this.messageConverter = messageConverter;
    }
}
