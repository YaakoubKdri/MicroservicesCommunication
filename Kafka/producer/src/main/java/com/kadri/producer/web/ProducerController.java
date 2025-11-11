package com.kadri.producer.web;

import com.kadri.producer.model.MessageEvent;
import com.kadri.producer.producer.EventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/api/v1/messages")
public class ProducerController {
    private final EventProducer producer;
    private final String topic;

    public ProducerController(EventProducer producer, @Value("${app.topic}") String topic) {
        this.producer = producer;
        this.topic = topic;
    }

    @PostMapping
    public ResponseEntity<String> postMessage(@RequestParam String text){
        MessageEvent messageEvent = MessageEvent.builder()
                .id(randomUUID().toString())
                .text(text)
                .timestamp(Instant.now())
                .build();
        producer.send(topic, messageEvent.getId(), messageEvent);
        return ResponseEntity.ok("Sent: " + messageEvent.getId());
    }
}
