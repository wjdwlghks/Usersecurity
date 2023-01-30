package com.ProTeen.backend.entity;

import jakarta.persistence.*;

@Entity
public class Article {
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "usersId")
    private User user;
}
