package com;

import com.buobao.eie.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by dqf on 2015/10/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class JmsTests {
    @Resource
    private ProducerService producerService;

    @Resource
    private Destination queueDestination;

    @Resource
    private Destination topicDestination;

    @Test
    public void testSend() {
        for (int i=1100; i<1108; i++) {
            producerService.sendMessage(queueDestination, "Hello,producer.This is message:" + (i+1));
        }
    }

    /**
     * ============================
     */

    @Test
    public void testSend1() {
        for (int i=0; i<2; i++) {
            producerService.sendMessage(topicDestination, "Hello,producer.This is message:" + (i+1));
        }
    }
}
