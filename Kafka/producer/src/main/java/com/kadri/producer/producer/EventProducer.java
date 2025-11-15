package com.kadri.producer.producer;

import com.kadri.producer.model.MessageEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EventProducer {
    private final KafkaTemplate<String, MessageEvent> kafkaTemplate;

    public EventProducer(KafkaTemplate<String, MessageEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public CompletableFuture<SendResult<String, MessageEvent>> send(String topic, String key, MessageEvent event){
        return kafkaTemplate.send(topic, key, event)
                .thenApply( result ->{
                    System.out.println("[Producer] Sent: " + result.getRecordMetadata());
                    return result;
                        });
    }
}
