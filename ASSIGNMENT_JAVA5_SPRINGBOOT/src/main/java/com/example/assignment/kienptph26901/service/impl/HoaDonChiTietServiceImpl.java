package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.HoaDonChiTiet;
import com.example.assignment.kienptph26901.repository.HoaDonChiTietRepository;
import com.example.assignment.kienptph26901.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public Page<HoaDonChiTiet> getAll(Integer pageNo, Integer size) {
        return hoaDonChiTietRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<HoaDonChiTiet> getHDCT() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public HoaDonChiTiet getOne(UUID id) {
        return hoaDonChiTietRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public void delete(UUID id) {
        hoaDonChiTietRepository.deleteById(id);
    }
}
