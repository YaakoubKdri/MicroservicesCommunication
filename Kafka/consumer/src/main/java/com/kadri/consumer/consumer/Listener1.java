package com.kadri.consumer.consumer;

import com.kadri.consumer.model.MessageEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener1 {

    @KafkaListener(topics = "${app.topic}", groupId = "my-shared-group", id = "listener-one")
    public void onMessage(MessageEvent messageEvent){
        System.out.println("[Listener1] Received: " + messageEvent);
    }
}
