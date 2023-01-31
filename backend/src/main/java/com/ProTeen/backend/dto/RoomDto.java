package com.ProTeen.backend.dto;

import com.ProTeen.backend.entity.ChatRoom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@NoArgsConstructor
@Getter
@ToString
public class RoomDto {

    private String roomId;
    private String createdAt;

    public RoomDto(String roomId, LocalDateTime createdAt) {
        this.roomId = roomId;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm:ss"
        ));
    }

    public RoomDto create() {
        RoomDto roomDto = new RoomDto();
        roomDto.roomId = UUID.randomUUID().toString();
        roomDto.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm:ss"
        ));
        return roomDto;
    }

    public ChatRoom toEntity() {
        return new ChatRoom(roomId, createdAt);
    }
}
