package com.example.demo.chat;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.chatroom.Chatroom;
import com.example.demo.user.User;

@Entity
@Table(name = "CHAT")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="sent_at")
    private LocalDateTime sentAt;

    @Column(name="message")
    private String message;

    @ManyToOne
    @JoinColumn(name="chatroom_id")
    private Chatroom chatroom;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;


    public Chat() {
    }

    public Chat(LocalDateTime sentAt, String message, Chatroom chatroom, User sender) {
        this.id = null;
        this.sentAt = sentAt;
        this.message = message;
        this.chatroom = chatroom;
        this.sender = sender;
    }

    public Chat(Long id, LocalDateTime sentAt, String message, Chatroom chatroom, User sender) {
        this.id = id;
        this.sentAt = sentAt;
        this.message = message;
        this.chatroom = chatroom;
        this.sender = sender;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getSentAt() {
        return this.sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Chatroom getChatroom() {
        return this.chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public User getSender() {
        return this.sender;
    }

    public void setSentBy(User sender) {
        this.sender = sender;
    }

}
