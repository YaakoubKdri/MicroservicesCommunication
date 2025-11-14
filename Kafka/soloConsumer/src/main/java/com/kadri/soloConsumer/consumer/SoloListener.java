package com.kadri.soloConsumer.consumer;

import com.kadri.soloConsumer.model.MessageEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SoloListener {

    @KafkaListener(topics = "${app.topic}", groupId = "my-unique-group", id = "solo-listener")
    public void onMessage(MessageEvent messageEvent){
        System.out.println("[SoloListener] Received: " + messageEvent);
    }
}
