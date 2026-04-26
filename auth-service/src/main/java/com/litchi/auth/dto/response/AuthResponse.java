package com.litchi.auth.dto.response;

public record AuthResponse(
        String token,
        String username
) {
}
