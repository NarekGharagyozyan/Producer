package com.producer.app.service.producer;

import com.producer.app.model.dto.user.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProducerServiceUser {

    private final KafkaTemplate<String, UserRequestDto> kafkaTemplate;

    @Value("${kafka.user.topic.name}")
    private String topicName;

    @Transactional
    public void sendMessage(UserRequestDto userRequestDto) {
        Message<UserRequestDto> message =
                MessageBuilder.withPayload(userRequestDto)
                        .setHeader(KafkaHeaders.TOPIC, topicName)
                        .build();

        kafkaTemplate.send(message);
    }
}

