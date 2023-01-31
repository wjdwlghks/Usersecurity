package com.ProTeen.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MessageDto {

    private String createdId;
    private String roomId;
    private String message;
    private String createdAt;

}
