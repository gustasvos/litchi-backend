package com.litchi.user.dto.response;

public record UserResponse(
        String id,
        String username,
        String avatarUrl,
        String presence
) {}