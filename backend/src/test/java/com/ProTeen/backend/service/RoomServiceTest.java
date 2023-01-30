package com.ProTeen.backend.service;

import com.ProTeen.backend.entity.ChatRoom;
import com.ProTeen.backend.repository.RoomRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceTest {

    @Autowired RoomService roomService;
    @Autowired RoomRepository roomRepository;

    @Test
    void create() {
        // 예상

        // 실제
        // ChatRoom actual = roomService.create();
        // 결과
    }

    @Test
    void find(String id) {


    }
}