package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.GioHangChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {

    Page<GioHangChiTiet> getAll(Integer pageNo, Integer size);

    List<GioHangChiTiet> getGHCT();

    GioHangChiTiet getOne(UUID id);

    void saveOrUpdate(GioHangChiTiet gioHangChiTiet);

    void delete(UUID id);

}
