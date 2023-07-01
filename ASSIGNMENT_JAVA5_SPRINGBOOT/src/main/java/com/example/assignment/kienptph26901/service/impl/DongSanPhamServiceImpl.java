package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.DongSanPham;
import com.example.assignment.kienptph26901.repository.DongSanPhamRepository;
import com.example.assignment.kienptph26901.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {

    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public Page<DongSanPham> getAll(Integer pageNo, Integer size) {
        return dongSanPhamRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<DongSanPham> getDongSP() {
        return dongSanPhamRepository.findAll();
    }

    @Override
    public DongSanPham getOne(UUID id) {
        return dongSanPhamRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(DongSanPham dongSanPham) {
        dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public void delete(UUID id) {
        dongSanPhamRepository.deleteById(id);
    }
}
