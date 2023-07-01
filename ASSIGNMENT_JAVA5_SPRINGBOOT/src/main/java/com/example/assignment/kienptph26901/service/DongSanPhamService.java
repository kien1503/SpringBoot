package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.ChucVu;
import com.example.assignment.kienptph26901.entity.DongSanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {

    Page<DongSanPham> getAll(Integer pageNo, Integer size);

    List<DongSanPham> getDongSP();

    DongSanPham getOne(UUID id);

    void saveOrUpdate(DongSanPham dongSanPham);

    void delete(UUID id);

}
