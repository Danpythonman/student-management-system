package com.example.demo.chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatroomService {

    private final ChatroomRepository chatroomRepository;

    @Autowired
    public ChatroomService(ChatroomRepository chatroomRepository) {
        this.chatroomRepository = chatroomRepository;
    }

    public Chatroom findChatroomById(Long id) {
        return this.chatroomRepository.findById(id).get();
    }

}
