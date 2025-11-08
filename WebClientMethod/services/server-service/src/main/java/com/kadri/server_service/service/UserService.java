package com.kadri.server_service.service;

import com.kadri.server_service.dto.UserDto;
import com.kadri.server_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Optional<UserDto> findById(Long id) {
        return repository.findById(id)
                .map(u -> UserDto.builder()
                        .id(u.getId())
                        .firstName(u.getFirstName())
                        .lastName(u.getLastName())
                        .email(u.getEmail())
                        .build());
    }
}
