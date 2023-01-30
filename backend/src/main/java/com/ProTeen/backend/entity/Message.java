package com.ProTeen.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "chatRoom_id")
    private ChatRoom chatRoom;

    @Column
    private LocalDateTime createdAt;
}
