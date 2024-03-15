package com.producer.app.service;

import com.producer.app.model.dto.user.UserRequestDto;
import com.producer.app.service.producer.ProducerServiceUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ProducerServiceUser producerServiceUser;

    @Override
    @Transactional
    public void registration(UserRequestDto userRequestDto) {
        producerServiceUser.sendMessage(userRequestDto);
        log.info("userRequestDto with username: {} sent to Kafka.",userRequestDto.getUsername());
    }

}