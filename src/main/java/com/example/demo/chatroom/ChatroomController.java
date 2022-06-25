package com.example.demo.chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatroomController {

    private final ChatroomService chatroomService;

    @Autowired
    public ChatroomController(ChatroomService chatroomService) {
        this.chatroomService = chatroomService;
    }

    @GetMapping("/chatroom/{id}")
    public String pageView(Model model, @PathVariable("id") Long id) {
        return "chatroom.html";
    }

}
