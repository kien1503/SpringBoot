package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.ChiTietSanPham;
import com.example.assignment.kienptph26901.repository.ChiTietSanPhamRepository;
import com.example.assignment.kienptph26901.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public Page<ChiTietSanPham> getAll(Integer pageNo, Integer size) {
        return chiTietSanPhamRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<ChiTietSanPham> getCTSP() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public ChiTietSanPham getOne(UUID id) {
        return chiTietSanPhamRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void delete(UUID id) {
        chiTietSanPhamRepository.deleteById(id);
    }
}
