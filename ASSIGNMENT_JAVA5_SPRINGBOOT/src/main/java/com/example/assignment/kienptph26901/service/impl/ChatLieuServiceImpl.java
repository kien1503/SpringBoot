package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.ChatLieu;
import com.example.assignment.kienptph26901.repository.ChatLieuRepository;
import com.example.assignment.kienptph26901.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Override
    public Page<ChatLieu> getAll(Integer pageNo, Integer size) {
        return chatLieuRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<ChatLieu> getCL() {
        return chatLieuRepository.findAll();
    }

    @Override
    public ChatLieu getOne(UUID id) {
        return chatLieuRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(ChatLieu chatLieu) {
        chatLieuRepository.save(chatLieu);
    }

    @Override
    public void delete(UUID id) {
        chatLieuRepository.deleteById(id);
    }
}
