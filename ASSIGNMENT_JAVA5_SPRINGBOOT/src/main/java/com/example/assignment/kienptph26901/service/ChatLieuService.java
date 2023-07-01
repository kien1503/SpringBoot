package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.ChatLieu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ChatLieuService {

    Page<ChatLieu> getAll(Integer pageNo, Integer size);

    List<ChatLieu> getCL();

    ChatLieu getOne(UUID id);

    void saveOrUpdate(ChatLieu chatLieu);

    void delete(UUID id);

}
