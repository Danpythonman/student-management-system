package com.example.demo.user_chatroom;

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
@Table(name = "USER_CHATROOM")
public class UserChatroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="chatroom_id")
    private Chatroom chatroom;

    public UserChatroom() {
    }

    public UserChatroom(User user, Chatroom chatroom) {
        this.id = null;
        this.user = user;
        this.chatroom = chatroom;
    }

    public UserChatroom(Long id, User user, Chatroom chatroom) {
        this.id = id;
        this.user = user;
        this.chatroom = chatroom;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public Chatroom getChatroom() {
        return this.chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

}
