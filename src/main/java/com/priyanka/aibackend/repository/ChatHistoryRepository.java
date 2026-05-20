package com.priyanka.aibackend.repository;

import com.priyanka.aibackend.entity.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {

    // Get all chats sorted by latest first
    List<ChatHistory> findAllByOrderByCreatedAtDesc();

}