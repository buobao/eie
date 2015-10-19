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
            System.out.println("Receive a text message.");
             try{
                 System.out.println("Context is:"+new String(textMsg.getText().getBytes(),"UTF-8"));
             }catch (JMSException e){
                 e.printStackTrace();
             }catch (Exception e){
                 e.printStackTrace();
             }
        } else if (message instanceof MapMessage){
            MapMessage mapMessage = (MapMessage)message;
        } else if (message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage)message;
            try{
                Email email = (Email)messageConverter.fromMessage(objectMessage);
                System.out.println("Receive a ObjectMessage,contains a Email object.");
                System.out.println(email.toString());
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
