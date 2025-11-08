package com.kadri.client.controller;

import com.kadri.client.dto.UserDto;
import com.kadri.client.service.RemoteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/client/users")
@RequiredArgsConstructor
public class ClientController {

    private final RemoteUserService service;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserDto>> getUser(@PathVariable Long id){
        return service.getUserById(id)
                .onErrorResume(e ->{
                    return Mono.just(ResponseEntity.status(502).build());
                });
    }
}
