package com.litchi.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    private String avatarUrl;

    @Enumerated(EnumType.STRING)
    private PresenceStatus presence = PresenceStatus.OFFLINE;

    public enum PresenceStatus {
        ONLINE, OFFLINE
    }
}