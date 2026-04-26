package com.litchi.user.controller;

import com.litchi.user.dto.request.UpdateUserRequest;
import com.litchi.user.dto.response.UserResponse;
import com.litchi.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserResponse getMe(@RequestHeader("X-User-Id") String userId) {
        return userService.getMe(userId);
    }

    @PutMapping("/me")
    public UserResponse update(@RequestHeader("X-User-Id") String userId,
                               @Valid @RequestBody UpdateUserRequest request) {
        return userService.update(userId, request);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable String id) {
        return userService.getById(id);
    }
}