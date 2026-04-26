package com.litchi.user.service;

import com.litchi.user.dto.request.UpdateUserRequest;
import com.litchi.user.dto.response.UserResponse;
import com.litchi.user.model.User;
import com.litchi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getMe(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return toResponse(user);
    }

    public UserResponse getById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return toResponse(user);
    }

    public UserResponse update(String userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (!user.getUsername().equals(request.username()) &&
                userRepository.existsByUsername(request.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already in use");
        }

        user.setUsername(request.username());
        user.setAvatarUrl(request.avatarUrl());
        return toResponse(userRepository.save(user));
    }

    public User createUser(String id, String username) {
        User user = User.builder()
                .id(id)
                .username(username)
                .presence(User.PresenceStatus.OFFLINE)
                .build();
        return userRepository.save(user);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getAvatarUrl(),
                user.getPresence().name()
        );
    }
}