package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    Page<NhanVien> getAll(Integer pageNo, Integer size);

    List<NhanVien> getNV();

    NhanVien getOne(UUID id);

    void saveOrUpdate(NhanVien nhanVien);

    void delete(UUID id);

}
