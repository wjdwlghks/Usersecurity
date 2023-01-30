package com.ProTeen.backend.controller;

import com.ProTeen.backend.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessageSendingOperations template;

    // 보내기 버튼 -> /pub/message
    @MessageMapping("/message")
    public void message(MessageDto messageDto) {
        template.convertAndSend("/sub/room/" + messageDto.getRoomId(), messageDto);
    }
}
