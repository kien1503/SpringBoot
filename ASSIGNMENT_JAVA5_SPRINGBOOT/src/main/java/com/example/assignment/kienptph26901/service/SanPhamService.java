package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    Page<SanPham> getAll(Integer pageNo, Integer size);

    List<SanPham> getSP();

    SanPham getOne(UUID id);

    void saveOrUpdate(SanPham sanPham);

    void delete(UUID id);

}
