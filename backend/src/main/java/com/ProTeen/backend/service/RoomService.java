package com.ProTeen.backend.service;

import com.ProTeen.backend.dto.RoomDto;
import com.ProTeen.backend.entity.ChatRoom;
import com.ProTeen.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public ChatRoom create() {
        RoomDto roomDto = new RoomDto().create();
        return roomRepository.save(roomDto.toEntity());
    }

    public ChatRoom find(String id) {
        return roomRepository.findById(id).orElse(null);
    }
}
