package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.chatroom.ChatroomInterface;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query(
        value = "SELECT chatroom.id AS id, chatroom.name AS name, chatroom.owner_id as owner_id FROM chatroom"
            + " INNER JOIN user_chatroom"
            + " ON chatroom.id = user_chatroom.chatroom_id"
            + " WHERE user_chatroom.user_id = :id",
        nativeQuery = true
    )
    List<ChatroomInterface> findChatroomsForUser(@Param("id") Long id);

}
