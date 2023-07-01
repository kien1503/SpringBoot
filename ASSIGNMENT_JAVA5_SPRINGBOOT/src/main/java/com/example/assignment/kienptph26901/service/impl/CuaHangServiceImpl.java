package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.CuaHang;
import com.example.assignment.kienptph26901.repository.CuaHangRepository;
import com.example.assignment.kienptph26901.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public Page<CuaHang> getAll(Integer pageNo, Integer size) {
        return cuaHangRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<CuaHang> getCH() {
        return cuaHangRepository.findAll();
    }

    @Override
    public CuaHang getOne(UUID id) {
        return cuaHangRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void delete(UUID id) {
        cuaHangRepository.deleteById(id);
    }
}
