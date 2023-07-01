package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {

    Page<ChiTietSanPham> getAll(Integer pageNo, Integer size);

    List<ChiTietSanPham> getCTSP();

    ChiTietSanPham getOne(UUID id);

    void saveOrUpdate(ChiTietSanPham chiTietSanPham);

    void delete(UUID id);

}
