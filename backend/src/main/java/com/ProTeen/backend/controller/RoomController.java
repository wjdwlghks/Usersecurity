package com.ProTeen.backend.controller;

import com.ProTeen.backend.entity.ChatRoom;
import com.ProTeen.backend.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class RoomController {

    @Autowired
    private RoomService roomService;

    // 채팅방 개설
    @GetMapping("/room/create")
    public String createRoom() {
        ChatRoom chatRoom = roomService.create();
        return "redirect:/room/" + chatRoom.getId();
    }

    // 채팅방 입장
    @GetMapping("/room/{id}")
    public String enterRoom(@PathVariable String id, Model model) {
        ChatRoom room = roomService.find(id);
        model.addAttribute("room", room);
        return "/test";
    }



}
