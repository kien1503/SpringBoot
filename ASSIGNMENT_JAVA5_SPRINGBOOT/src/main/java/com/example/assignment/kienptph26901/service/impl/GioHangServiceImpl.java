package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.GioHang;
import com.example.assignment.kienptph26901.repository.GioHangRepository;
import com.example.assignment.kienptph26901.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;

    @Override
    public Page<GioHang> getAll(Integer pageNo, Integer size) {
        return gioHangRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<GioHang> getGH() {
        return gioHangRepository.findAll();
    }

    @Override
    public GioHang getOne(UUID id) {
        return gioHangRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(GioHang gioHang) {
        gioHangRepository.save(gioHang);
    }

    @Override
    public void delete(UUID id) {
        gioHangRepository.deleteById(id);
    }
}
