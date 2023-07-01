package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.SanPham;
import com.example.assignment.kienptph26901.repository.SanPhamRepository;
import com.example.assignment.kienptph26901.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public Page<SanPham> getAll(Integer pageNo, Integer size) {
        return sanPhamRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<SanPham> getSP() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham getOne(UUID id) {
        return sanPhamRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void delete(UUID id) {
        sanPhamRepository.deleteById(id);
    }
}
