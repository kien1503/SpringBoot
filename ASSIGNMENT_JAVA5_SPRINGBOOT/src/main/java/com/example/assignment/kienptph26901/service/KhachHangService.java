package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.HoaDon;
import com.example.assignment.kienptph26901.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {

    Page<KhachHang> getAll(Integer pageNo, Integer size);

    List<KhachHang> getKH();

    KhachHang getOne(UUID id);

    void saveOrUpdate(KhachHang khachHang);

    void delete(UUID id);

}
