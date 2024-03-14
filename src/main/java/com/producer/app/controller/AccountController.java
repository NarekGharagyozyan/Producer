package com.producer.app.controller;

import com.producer.app.model.dto.user.UserRequestDto;
import com.producer.app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/account")
public class AccountController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody @Valid UserRequestDto userRequestDto) {
        userService.registration(userRequestDto);
        return ResponseEntity.ok().build();
    }

}