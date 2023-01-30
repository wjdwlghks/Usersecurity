package com.ProTeen.backend.entity;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    private Long id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "usersId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;
}
