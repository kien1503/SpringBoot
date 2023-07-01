package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.GioHangChiTiet;
import com.example.assignment.kienptph26901.repository.GioHangChiTietRepository;
import com.example.assignment.kienptph26901.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public Page<GioHangChiTiet> getAll(Integer pageNo, Integer size) {
        return gioHangChiTietRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<GioHangChiTiet> getGHCT() {
        return gioHangChiTietRepository.findAll();
    }

    @Override
    public GioHangChiTiet getOne(UUID id) {
        return gioHangChiTietRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(GioHangChiTiet gioHangChiTiet) {
        gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public void delete(UUID id) {
        gioHangChiTietRepository.deleteById(id);
    }
}
