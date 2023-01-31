package com.ProTeen.backend.entity;

import jakarta.persistence.*;

@Entity
public class Test {

    public enum statusType {
        Good, Bad
    }

    @Id
    private Long id;

    @Column
    private int score;

    @Column
    private statusType status;

    @ManyToOne
    @JoinColumn(name = "usersId")
    private User user;
}
