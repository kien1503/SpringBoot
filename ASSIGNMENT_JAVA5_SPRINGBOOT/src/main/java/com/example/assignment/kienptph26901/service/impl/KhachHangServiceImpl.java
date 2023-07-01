package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.KhachHang;
import com.example.assignment.kienptph26901.repository.KhachHangRepository;
import com.example.assignment.kienptph26901.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> getAll(Integer pageNo, Integer size) {
        return khachHangRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<KhachHang> getKH() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang getOne(UUID id) {
        return khachHangRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void delete(UUID id) {
        khachHangRepository.deleteById(id);
    }
}
