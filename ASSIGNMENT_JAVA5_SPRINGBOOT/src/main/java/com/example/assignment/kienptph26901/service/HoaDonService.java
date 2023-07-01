package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.HoaDon;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {

    Page<HoaDon> getAll(Integer pageNo, Integer size);

    List<HoaDon> getHD();

    HoaDon getOne(UUID id);

    void saveOrUpdate(HoaDon hoaDon);

    void delete(UUID id);

}
