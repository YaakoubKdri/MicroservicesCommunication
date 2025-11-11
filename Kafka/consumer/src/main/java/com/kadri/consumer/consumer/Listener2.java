package com.kadri.consumer.consumer;

import com.kadri.consumer.model.MessageEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener2 {

    @KafkaListener(topics = "${app.topic}", groupId = "my-shared-group", id = "listener-two")
    public void onMessage(MessageEvent messageEvent){
        System.out.println("[Listener2] Received: " + messageEvent);
    }
}
