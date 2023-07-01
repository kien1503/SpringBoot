package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.HoaDonChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {

    Page<HoaDonChiTiet> getAll(Integer pageNo, Integer size);

    List<HoaDonChiTiet> getHDCT();

    HoaDonChiTiet getOne(UUID id);

    void saveOrUpdate(HoaDonChiTiet hoaDonChiTiet);

    void delete(UUID id);

}
