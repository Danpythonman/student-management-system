package com.example.demo.chatroom;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.user.User;
import com.example.demo.user_chatroom.UserChatroom;

@Entity
@Table(name = "CHATROOM")
public class Chatroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    String name;

    @Column(name="owner_id")
    private User owner;

    @OneToMany(mappedBy = "chatroom")
    private List<UserChatroom> userChatroomConnections;

    public Chatroom() {
    }

    public Chatroom(String name, User owner) {
        this.id = null;
        this.name = name;
        this.owner = owner;
    }

    public Chatroom(Long id, String name, User owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
