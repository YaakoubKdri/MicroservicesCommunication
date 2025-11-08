package com.kadri.client.service;

import com.kadri.client.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RemoteUserService {

    private final WebClient webClient;

    public Mono<ResponseEntity<UserDto>> getUserById(Long id){
        return webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .toEntity(UserDto.class);
    }
}
