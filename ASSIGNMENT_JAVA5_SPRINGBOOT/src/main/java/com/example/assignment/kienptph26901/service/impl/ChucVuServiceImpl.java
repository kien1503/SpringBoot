package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.ChucVu;
import com.example.assignment.kienptph26901.repository.ChucVuRepository;
import com.example.assignment.kienptph26901.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public Page<ChucVu> getAll(Integer pageNo, Integer size) {
        return chucVuRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<ChucVu> getCV() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu getOne(UUID id) {
        return chucVuRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void delete(UUID id) {
        chucVuRepository.deleteById(id);
    }
}
