package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.CuaHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    Page<CuaHang> getAll(Integer pageNo, Integer size);

    List<CuaHang> getCH();

    CuaHang getOne(UUID id);

    void saveOrUpdate(CuaHang cuaHang);

    void delete(UUID id);

}
