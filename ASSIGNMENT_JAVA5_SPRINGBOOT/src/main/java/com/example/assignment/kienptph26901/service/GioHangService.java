package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.GioHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface GioHangService {

    Page<GioHang> getAll(Integer pageNo, Integer size);

    List<GioHang> getGH();

    GioHang getOne(UUID id);

    void saveOrUpdate(GioHang gioHang);

    void delete(UUID id);

}
